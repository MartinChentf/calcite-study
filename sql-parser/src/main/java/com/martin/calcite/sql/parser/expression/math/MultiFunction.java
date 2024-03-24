package com.martin.calcite.sql.parser.expression.math;

import java.math.BigDecimal;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.metadata.DataType;

/**
 * MultiExpression <br>
 * 乘法表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class MultiFunction<T extends Number> extends ArithmeticExpression<T> {

    public MultiFunction() {
        // NOP
    }

    private MultiFunction(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    public static MultiFunction<?> create(Expression<?> operand1, Expression<?> operand2) {
        return new MultiFunction<>(operand1, operand2);
    }

    @Override
    protected Number evalNumeric(Number left, Number right, DataType resultType) {
        switch (resultType) {
            case TINYINT:
                return (byte) (left.byteValue() * right.byteValue());
            case SMALLINT:
                return (short) (left.shortValue() * right.shortValue());
            case INTEGER:
                return left.intValue() * right.intValue();
            case BIGINT:
                try {
                    return Math.multiplyExact(left.longValue(), right.longValue());
                } catch (ArithmeticException e) {
                    throw new RuntimeException(
                        "BIGINT overflow in '*' operator (consider adding explicit CAST to DECIMAL)");
                }
            case FLOAT:
                return left.floatValue() * right.floatValue();
            case DOUBLE:
                return left.doubleValue() * right.doubleValue();
            case DECIMAL:
                return new BigDecimal(left.toString()).multiply(new BigDecimal(right.toString()));
            default:
                throw new IllegalArgumentException("unexpected result type: " + resultType);
        }
    }
}
