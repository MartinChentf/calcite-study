package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlKind;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.ComparisonMode;
import com.martin.calcite.sql.parser.expression.predicate.ComparisonPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * ComparisonPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ComparisonPredicateConverter extends AbstractExpressionConverter<ComparisonPredicate> {

    @Override
    protected ComparisonPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return new ComparisonPredicate(operands.get(0), operands.get(1), convert2ComparisonMode(call.getKind()));
    }

    private ComparisonMode convert2ComparisonMode(SqlKind kind) {
        switch (kind) {
            case EQUALS:
                return ComparisonMode.EQUALS;
            case NOT_EQUALS:
                return ComparisonMode.NOT_EQUALS;
            case LESS_THAN:
                return ComparisonMode.LESS_THAN;
            case LESS_THAN_OR_EQUAL:
                return ComparisonMode.LESS_THAN_OR_EQUAL;
            case GREATER_THAN:
                return ComparisonMode.GREATER_THAN;
            case GREATER_THAN_OR_EQUAL:
                return ComparisonMode.GREATER_THAN_OR_EQUAL;
            default:
                throw new UnsupportedOperationException("不支持的比较类型：" + kind);
        }
    }
}
