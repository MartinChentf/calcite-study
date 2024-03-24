package com.martin.calcite.sql.parser.expression;

/**
 * NullsLastExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsLastExpression<T> extends UniExpression<T> {

    public NullsLastExpression() {
        // NOP
    }

    private NullsLastExpression(Expression<?> operand) {
        super(operand);
    }

    public static NullsLastExpression<?> create(Expression<?> operand) {
        return new NullsLastExpression<>(operand);
    }
}
