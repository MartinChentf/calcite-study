package com.martin.calcite.sql.parser.expression;

/**
 * TriExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class TriExpression<T> implements Expression<T> {

    protected Expression<?> operand1;
    protected Expression<?> operand2;
    protected Expression<?> operand3;

    public TriExpression(Expression<?> operand1, Expression<?> operand2, Expression<?> operand3) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    public Expression<?> getOperand1() {
        return operand1;
    }

    public Expression<?> getOperand2() {
        return operand2;
    }

    public Expression<?> getOperand3() {
        return operand3;
    }
}
