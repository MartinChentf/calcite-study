package com.martin.calcite.sql.parser.expression;

/**
 * UniExpression <br>
 * 一元表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class UniExpression<T> implements Expression<T> {

    private Expression<?> operand;

    public UniExpression() {
    }

    public UniExpression(Expression<?> operand) {
        this.operand = operand;
    }

    public Expression<?> getOperand() {
        return operand;
    }

    public void setOperand(Expression<?> operand) {
        this.operand = operand;
    }
}
