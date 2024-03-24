package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.ExpressionList;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * TristateLogic <br>
 * 三态逻辑工具类。用于处理具有 true、false、null 三种状态的布尔值
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public final class TernaryLogic {

    private TernaryLogic() {
        // NOP
    }

    /**
     * Performs AND for the given operands acting on the given row in the given
     * context.
     * <p>
     * The method exhibits a short-circuiting behaviour: there is no guarantee
     * all of the passed operands would be evaluated. Operand evaluation order
     * is unspecified.
     *
     * @param row      the row to evaluate the operands on.
     * @param operands the boolean operands to evaluate.
     * @return {@code true} if all of the operands were evaluated to {@code true},
     * {@code false} if at least one of the operands was evaluated to {@code false},
     * {@code null} otherwise.
     */
    public static Boolean and(RowSet row, ExpressionList operands) {
        boolean seenUnknown = false;

        for (Expression<?> operand : operands) {
            Boolean result = (Boolean) operand.eval(row);

            if (isFalse(result)) {
                return Boolean.FALSE;
            }

            if (isNull(result)) {
                seenUnknown = true;
            }
        }

        return seenUnknown ? null : Boolean.TRUE;
    }

    /**
     * Performs OR for the given operands acting on the given row in the given
     * context.
     * <p>
     * The method exhibits a short-circuiting behaviour: there is no guarantee
     * all of the passed operands would be evaluated. Operand evaluation order
     * is unspecified.
     *
     * @param row      the row to evaluate the operands on.
     * @param operands the boolean operands to evaluate.
     * @return {@code false} if all of the operands were evaluated to {@code false},
     * {@code true} if at least one of the operands was evaluated to {@code true},
     * {@code null} otherwise.
     */
    public static Boolean or(RowSet row, ExpressionList operands) {
        boolean seenUnknown = false;

        for (Expression<?> operand : operands) {
            Boolean result = (Boolean) operand.eval(row);

            if (isTrue(result)) {
                return Boolean.TRUE;
            }

            if (isNull(result)) {
                seenUnknown = true;
            }
        }

        return seenUnknown ? null : Boolean.FALSE;
    }

    /**
     * Negates the given boolean value.
     *
     * @param value the value to negate.
     * @return {@code true} if the passed value was {@code false}, {@code false}
     * if it was {@code true}, {@code null} if it was {@code null}.
     */
    public static Boolean not(Boolean value) {
        return value == null ? null : !value;
    }

    /**
     * Checks whether the given value is {@code null}.
     *
     * @param value the value to check.
     * @return {@code true} if the passed value is {@code null}, {@code false}
     * otherwise.
     */
    public static boolean isNull(Object value) {
        return value == null;
    }

    /**
     * Checks whether the given value is not {@code null}.
     *
     * @param value the value to check.
     * @return {@code false} if the passed value is {@code null}, {@code true}
     * otherwise.
     */
    public static boolean isNotNull(Object value) {
        return value != null;
    }

    /**
     * Checks whether the given value is {@code true}.
     *
     * @param value the value to check.
     * @return {@code true} if the passed value is {@code true}; {@code false}
     * otherwise, i.e. the passed value is either {@code false} or {@code null}.
     */
    public static boolean isTrue(Boolean value) {
        return value != null && value;
    }

    /**
     * Checks whether the given value is not {@code true}.
     *
     * @param value the value to check.
     * @return {@code true} if the passed value is either {@code false} or
     * {@code null}; {@code false} otherwise, i.e. the passed value is {@code
     * true}.
     */
    public static boolean isNotTrue(Boolean value) {
        return value == null || !value;
    }

    /**
     * Checks whether the given value is {@code false}.
     *
     * @param value the value to check.
     * @return {@code true} if the passed value is {@code false}; {@code false}
     * otherwise, i.e. the passed value is either {@code true} or {@code null}.
     */
    public static boolean isFalse(Boolean value) {
        return value != null && !value;
    }

    /**
     * Checks whether the given value is not {@code false}.
     *
     * @param value the value to check.
     * @return {@code true} if the passed value is either {@code true} or
     * {@code null}; {@code false} otherwise, i.e. the passed value is {@code
     * false}.
     */
    public static boolean isNotFalse(Boolean value) {
        return value == null || value;
    }
}
