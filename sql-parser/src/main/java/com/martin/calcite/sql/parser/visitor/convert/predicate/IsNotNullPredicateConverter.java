package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.IsNotNullPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * IsNotNullPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotNullPredicateConverter extends AbstractExpressionConverter<IsNotNullPredicate> {
    @Override
    protected IsNotNullPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return IsNotNullPredicate.create(operands.get(0));
    }
}
