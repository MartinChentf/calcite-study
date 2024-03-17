package com.martin.calcite.sql.parser.expression;

/**
 * NullsFirstExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsFirstExpression<T> extends UniExpression<T> {
    public NullsFirstExpression(Expression<?> operand) {
        super(operand);
    }

    @Override
    public T eval(Object object) {
        return null;
    }
}
