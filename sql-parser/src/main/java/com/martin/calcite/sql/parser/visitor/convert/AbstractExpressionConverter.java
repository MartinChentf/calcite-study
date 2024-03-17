package com.martin.calcite.sql.parser.visitor.convert;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.visitor.SqlToExprVisitor;

/**
 * AbstractExpressionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class AbstractExpressionConverter<T extends Expression<?>> implements ExpressionConverter<T> {

    @Override
    public T convert(SqlCall call, SqlToExprVisitor visitor) {
        List<Expression<?>> operands = visitor.visitNodeList(call.getOperandList());
        return newInstance(call, operands);
    }

    /**
     * 构建表达式实例
     *
     * @param call SqlCall 对象
     * @param operands 操作数
     * @return 表达式对象
     */
    protected abstract T newInstance(SqlCall call, List<Expression<?>> operands);
}
