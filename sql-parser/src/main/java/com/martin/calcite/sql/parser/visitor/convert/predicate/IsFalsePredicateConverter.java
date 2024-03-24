package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.IsFalsePredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * IsFalsePredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsFalsePredicateConverter extends AbstractExpressionConverter<IsFalsePredicate> {
    @Override
    protected IsFalsePredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return IsFalsePredicate.create(operands.get(0));
    }
}
