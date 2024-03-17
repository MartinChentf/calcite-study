package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;

/**
 * IsNotNullPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotNullPredicate extends UniExpression<Boolean> {
    public IsNotNullPredicate(Expression<?> expression) {
        super(expression);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
