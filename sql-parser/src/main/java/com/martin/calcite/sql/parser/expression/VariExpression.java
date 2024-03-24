package com.martin.calcite.sql.parser.expression;

import java.util.Arrays;
import java.util.Collection;

/**
 * VariExpression <br>
 * 多元表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class VariExpression<T> implements Expression<T> {

    protected ExpressionList operands;

    protected VariExpression() {
        this.operands = new ExpressionList();
    }

    protected VariExpression(Expression<?>... operands) {
        this.operands = new ExpressionList(Arrays.asList(operands));
    }

    public void addOperand(Expression<?> operand) {
        this.operands.add(operand);
    }

    public void addOperands(Collection<Expression<?>> operands) {
        this.operands.addAll(operands);
    }
}
