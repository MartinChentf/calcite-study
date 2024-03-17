package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.IsTruePredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * IsTruePredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsTruePredicateConverter extends AbstractExpressionConverter<IsTruePredicate> {
    @Override
    protected IsTruePredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return new IsTruePredicate(operands.get(0));
    }
}
