package com.martin.calcite.sql.parser.expression.string;

import com.martin.calcite.sql.parser.expression.BiExpression;
import com.martin.calcite.sql.parser.expression.Expression;

/**
 * LikeFunction <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class LikeFunction extends BiExpression<Boolean> {

    private boolean negated;

    public LikeFunction(Expression<?> operand1, Expression<?> operand2, boolean negated) {
        super(operand1, operand2);
        this.negated = negated;
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }

    public boolean isNegated() {
        return negated;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }
}
