package com.martin.calcite.sql.parser.expression;

/**
 * BiExpression <br>
 * 二元表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class BiExpression<T> implements Expression<T> {

    private Expression<?> operand1;
    private Expression<?> operand2;

    public BiExpression() {
    }

    public BiExpression(Expression<?> operand1, Expression<?> operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Expression<?> getOperand1() {
        return operand1;
    }

    public void setOperand1(Expression<?> operand1) {
        this.operand1 = operand1;
    }

    public Expression<?> getOperand2() {
        return operand2;
    }

    public void setOperand2(Expression<?> operand2) {
        this.operand2 = operand2;
    }
}
