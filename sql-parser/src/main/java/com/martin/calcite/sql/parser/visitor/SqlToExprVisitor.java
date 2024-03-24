package com.martin.calcite.sql.parser.visitor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.calcite.sql.SqlBasicCall;
import org.apache.calcite.sql.SqlBinaryStringLiteral;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlCharStringLiteral;
import org.apache.calcite.sql.SqlDataTypeSpec;
import org.apache.calcite.sql.SqlDateLiteral;
import org.apache.calcite.sql.SqlDynamicParam;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlIntervalQualifier;
import org.apache.calcite.sql.SqlLiteral;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlNodeList;
import org.apache.calcite.sql.SqlNumericLiteral;
import org.apache.calcite.sql.SqlOrderBy;
import org.apache.calcite.sql.SqlSelect;
import org.apache.calcite.sql.SqlTimeLiteral;
import org.apache.calcite.sql.SqlTimestampLiteral;
import org.apache.calcite.sql.util.SqlBasicVisitor;
import org.apache.calcite.util.BitString;
import org.apache.calcite.util.DateString;
import org.apache.calcite.util.NlsString;
import org.apache.calcite.util.TimeString;
import org.apache.calcite.util.TimestampString;

import com.martin.calcite.sql.parser.expression.ColumnExpression;
import com.martin.calcite.sql.parser.expression.ConstantExpression;
import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.ExpressionList;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.visitor.convert.ExpressionConverter;
import com.martin.calcite.sql.parser.visitor.convert.ExpressionConverterManager;

/**
 * SqlToExprVisitor <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class SqlToExprVisitor extends SqlBasicVisitor<Expression<?>> {

    private final QuerySegmentType type;

    public SqlToExprVisitor(QuerySegmentType type) {
        this.type = type;
    }

    @Override
    public Expression<?> visit(SqlLiteral literal) {
        ConstantExpression<?> expression;
        if (literal instanceof SqlNumericLiteral) {
            SqlNumericLiteral numericLiteral = (SqlNumericLiteral) literal;
            BigDecimal value = literal.getValueAs(BigDecimal.class);
            expression = ConstantExpression.create(value, numericLiteral.isExact() ? DataType.DECIMAL : DataType.DOUBLE);
        } else if (literal instanceof SqlBinaryStringLiteral) {
            BitString value = literal.getValueAs(BitString.class);
            expression = ConstantExpression.create(value.toString(), DataType.VARCHAR);
        } else if (literal instanceof SqlCharStringLiteral) {
            NlsString value = literal.getValueAs(NlsString.class);
            expression = ConstantExpression.create(value.getValue(), DataType.VARCHAR);
        } else if (literal instanceof SqlDateLiteral) {
            DateString value = literal.getValueAs(DateString.class);
            expression = ConstantExpression.create(new Date(value.getMillisSinceEpoch()), DataType.DATE);
        } else if (literal instanceof SqlTimeLiteral) {
            TimeString value = literal.getValueAs(TimeString.class);
            expression = ConstantExpression.create(new Time(value.getMillisOfDay()), DataType.TIME);
        } else if (literal instanceof SqlTimestampLiteral) {
            TimestampString value = literal.getValueAs(TimestampString.class);
            expression = ConstantExpression.create(new Timestamp(value.getMillisSinceEpoch()), DataType.TIMESTAMP);
        } else {
            throw new IllegalStateException("不支持的数据类型，" + literal.getClass().getName());
        }
        return expression;
    }

    @Override
    public Expression<?> visit(SqlCall call) {
        if (call instanceof SqlSelect) {
            switch (type) {
                case SELECT:
                    return visitNode(((SqlSelect) call).getSelectList());
                case WHERE:
                    return visitNode(((SqlSelect) call).getWhere());
                case GROUP:
                    return visitNode(((SqlSelect) call).getGroup());
                case ORDER:
                    return visitNode(((SqlSelect) call).getOrderList());
                case HAVING:
                    return visitNode(((SqlSelect) call).getHaving());
                default:
                    throw new UnsupportedOperationException("不支持解析的 SQL 片段：" + type);
            }
        } else if (call instanceof SqlOrderBy) {
            return visitNode(((SqlOrderBy) call).orderList);
        } else if (call instanceof SqlBasicCall) {
            ExpressionConverter<?> converter = ExpressionConverterManager.getConverter(call.getKind());
            if (converter == null) {
                throw new UnsupportedOperationException("不支持的操作类型，" + call.getKind() + ": " + call);
            }
            return converter.convert(call, this);
        }
        return super.visit(call);
    }

    @Override
    public Expression<?> visit(SqlNodeList nodeList) {
        return new ExpressionList(visitNodeList(nodeList.getList()));
    }

    @Override
    public Expression<?> visit(SqlIdentifier id) {
        return ColumnExpression.create(id.toString());
    }

    @Override
    public Expression<?> visit(SqlDataTypeSpec type) {
        throw new UnsupportedOperationException("不支持 " + type.getClass().getName() + " 转换成 Expression");
    }

    @Override
    public Expression<?> visit(SqlDynamicParam param) {
        throw new UnsupportedOperationException("不支持 " + param.getClass().getName() + " 转换成 Expression");
    }

    @Override
    public Expression<?> visit(SqlIntervalQualifier intervalQualifier) {
        throw new UnsupportedOperationException("不支持 " + intervalQualifier.getClass().getName() + " 转换成 Expression");
    }

    @Override
    public Expression<?> visitNode(SqlNode n) {
        if (n != null) {
            return super.visitNode(n);
        } else {
            return null;
        }
    }

    public List<Expression<?>> visitNodeList(List<SqlNode> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return new ArrayList<>(0);
        }
        List<Expression<?>> expressions = new ArrayList<>(nodeList.size());
        for (SqlNode sqlNode : nodeList) {
            expressions.add(sqlNode.accept(this));
        }
        return expressions;
    }
}
