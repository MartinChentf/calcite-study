package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.IsNotTruePredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * IsNotTruePredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotTruePredicateConverter extends AbstractExpressionConverter<IsNotTruePredicate> {
    @Override
    protected IsNotTruePredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return new IsNotTruePredicate(operands.get(0));
    }
}
