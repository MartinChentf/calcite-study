package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.AndPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * AndPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class AndPredicateConverter extends AbstractExpressionConverter<AndPredicate> {

    @Override
    protected AndPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return AndPredicate.create(operands.get(0), operands.get(1));
    }
}
