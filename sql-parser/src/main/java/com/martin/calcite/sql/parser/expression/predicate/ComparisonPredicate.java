package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.BiExpression;
import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * ComparisonPredicate <br>
 * 比较断言表达式：=、<>、>、>=、<、<=
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ComparisonPredicate extends BiExpression<Boolean> {

    protected ComparisonMode mode;

    public ComparisonPredicate() {
        // NOP
    }

    private ComparisonPredicate(Expression<?> operand1, Expression<?> operand2, ComparisonMode mode) {
        super(operand1, operand2);
        this.mode = mode;
    }

    public static ComparisonPredicate create(Expression<?> operand1, Expression<?> operand2, ComparisonMode mode) {
        return new ComparisonPredicate(operand1, operand2, mode);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Boolean eval(RowSet rowSet) {
        Object left = operand1.eval(rowSet);
        if (left == null) {
            return null;
        }

        Object right = operand2.eval(rowSet);
        if (right == null) {
            return null;
        }

        DataType leftType = operand1.evalType(rowSet);
        if (leftType == DataType.NULL || leftType == DataType.UNKNOWN) {
            Class<?> leftClass = left.getClass();
            Class<?> rightClass = right.getClass();

            if (!leftClass.equals(rightClass)) {
                throw new RuntimeException(
                    "Cannot compare two OBJECT values, because "
                        + "left operand has " + leftClass + " type and "
                        + "right operand has " + rightClass + " type");
            }

            if (!(left instanceof Comparable)) {
                throw new RuntimeException(
                    "Cannot compare OBJECT value because " + leftClass + " doesn't implement Comparable interface");
            }
        }

        Comparable leftComparable = (Comparable) left;
        Comparable rightComparable = (Comparable) right;

        int order = leftComparable.compareTo(rightComparable);

        switch (mode) {
            case EQUALS:
                return order == 0;

            case NOT_EQUALS:
                return order != 0;

            case GREATER_THAN:
                return order > 0;

            case GREATER_THAN_OR_EQUAL:
                return order >= 0;

            case LESS_THAN:
                return order < 0;

            case LESS_THAN_OR_EQUAL:
                return order <= 0;

            default:
                throw new IllegalStateException("unexpected comparison mode: " + mode);
        }
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }

    public ComparisonMode getMode() {
        return mode;
    }
}
