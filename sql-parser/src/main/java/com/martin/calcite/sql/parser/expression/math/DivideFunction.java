package com.martin.calcite.sql.parser.expression.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.metadata.DataType;

/**
 * DivideExpression <br>
 * 除法表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class DivideFunction<T extends Number> extends ArithmeticExpression<T> {

    public DivideFunction() {
        // NOP
    }

    private DivideFunction(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    public static DivideFunction<?> create(Expression<?> operand1, Expression<?> operand2) {
        return new DivideFunction<>(operand1, operand2);
    }

    @Override
    protected Number evalNumeric(Number left, Number right, DataType resultType) {
        try {
            switch (resultType) {
                case TINYINT:
                    return (byte) (left.byteValue() / right.byteValue());
                case SMALLINT:
                    return (short) (left.shortValue() / right.shortValue());
                case INTEGER:
                    return left.intValue() / right.intValue();
                case BIGINT:
                    if (left.longValue() == Long.MIN_VALUE && right.longValue() == -1) {
                        throw new RuntimeException(
                            "BIGINT overflow in '/' operator (consider adding explicit CAST to DECIMAL)");
                    }
                    return left.longValue() / right.longValue();
                case FLOAT:
                    return left.floatValue() / right.floatValue();
                case DOUBLE:
                    return left.doubleValue() / right.doubleValue();
                case DECIMAL:
                    return new BigDecimal(left.toString())
                        .divide(new BigDecimal(right.toString()), new MathContext(76, RoundingMode.HALF_UP));
                default:
                    throw new IllegalArgumentException("unexpected result type: " + resultType);
            }
        } catch (ArithmeticException e) {
            throw new RuntimeException("Division by zero");
        }
    }
}
