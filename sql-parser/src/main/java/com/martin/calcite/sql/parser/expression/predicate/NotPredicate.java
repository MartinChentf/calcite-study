package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;

/**
 * NotExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NotPredicate extends UniExpression<Boolean> {

    public NotPredicate() {
    }

    public NotPredicate(Expression<?> operand) {
        super(operand);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
