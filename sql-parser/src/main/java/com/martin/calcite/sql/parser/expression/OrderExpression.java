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

    public OrderExpression(Expression<?> operand, boolean isDesc) {
        super(operand);
        this.isDesc = isDesc;
    }

    @Override
    public T eval(Object object) {
        return null;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean desc) {
        isDesc = desc;
    }
}
