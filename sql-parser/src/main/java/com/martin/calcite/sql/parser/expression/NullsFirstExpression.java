package com.martin.calcite.sql.parser.expression;

/**
 * NullsFirstExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsFirstExpression<T> extends UniExpression<T> {

    public NullsFirstExpression() {
        // NOP
    }

    private NullsFirstExpression(Expression<?> operand) {
        super(operand);
    }

    public static NullsFirstExpression<?> create(Expression<?> operand) {
        return new NullsFirstExpression<>(operand);
    }
}
