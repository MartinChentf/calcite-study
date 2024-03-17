package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.IsNullPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * IsNullPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNullPredicateConverter extends AbstractExpressionConverter<IsNullPredicate> {
    @Override
    protected IsNullPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return new IsNullPredicate(operands.get(0));
    }
}
