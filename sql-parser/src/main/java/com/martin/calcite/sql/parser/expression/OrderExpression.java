package com.martin.calcite.sql.parser.expression;

/**
 * OrderExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class OrderExpression<T> extends UniExpression<T> {

    private boolean isDesc = false;

    public OrderExpression() {
        // NOP
    }

    private OrderExpression(Expression<?> operand, boolean isDesc) {
        super(operand);
        this.isDesc = isDesc;
    }

    public static OrderExpression<?> create(Expression<?> operand, boolean isDesc) {
        return new OrderExpression<>(operand, isDesc);
    }

    public boolean isDesc() {
        return isDesc;
    }
}
