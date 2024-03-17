package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.VariExpression;

/**
 * AndPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class AndPredicate extends VariExpression<Boolean> {

    public AndPredicate() {
    }

    public AndPredicate(Expression<?>... operands) {
        super(operands);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
