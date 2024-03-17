package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.BiExpression;
import com.martin.calcite.sql.parser.expression.Expression;

/**
 * ComparisonPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ComparisonPredicate extends BiExpression<Boolean> {

    protected ComparisonMode mode;

    public ComparisonPredicate() {
    }

    public ComparisonPredicate(Expression<?> operand1, Expression<?> operand2, ComparisonMode mode) {
        super(operand1, operand2);
        this.mode = mode;
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }

    public ComparisonMode getMode() {
        return mode;
    }

    public void setMode(ComparisonMode mode) {
        this.mode = mode;
    }
}
