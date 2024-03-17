package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;

/**
 * IsNotFalsePredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotFalsePredicate extends UniExpression<Boolean> {
    public IsNotFalsePredicate(Expression<?> expression) {
        super(expression);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
