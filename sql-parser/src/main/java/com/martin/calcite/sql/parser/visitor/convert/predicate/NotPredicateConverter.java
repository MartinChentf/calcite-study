package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.NotPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * NotPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NotPredicateConverter extends AbstractExpressionConverter<NotPredicate> {

    @Override
    protected NotPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return NotPredicate.create(operands.get(0));
    }
}
