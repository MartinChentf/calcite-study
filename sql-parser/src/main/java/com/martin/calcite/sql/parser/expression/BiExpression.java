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

    protected Expression<?> operand1;
    protected Expression<?> operand2;

    protected BiExpression() {
        // NOP
    }

    protected BiExpression(Expression<?> operand1, Expression<?> operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Expression<?> getOperand1() {
        return operand1;
    }

    public Expression<?> getOperand2() {
        return operand2;
    }
}
