package com.martin.calcite.sql.parser.expression;

/**
 * NullsLastExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsLastExpression<T> extends UniExpression<T> {
    public NullsLastExpression(Expression<?> operand) {
        super(operand);
    }

    @Override
    public T eval(Object object) {
        return null;
    }
}
