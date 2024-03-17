package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;

/**
 * IsNullPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNullPredicate extends UniExpression<Boolean> {

    public IsNullPredicate(Expression<?> operand) {
        super(operand);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
