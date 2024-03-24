package com.martin.calcite.sql.parser.expression.math;

import com.martin.calcite.sql.parser.expression.BiExpression;
import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * ArithmeticExpression <br>
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public abstract class ArithmeticExpression<T extends Number> extends BiExpression<T> {

    protected ArithmeticExpression() {
        // NOP
    }

    protected ArithmeticExpression(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T eval(RowSet rowSet) {
        Object left = operand1.eval(rowSet);
        if (left == null) {
            return null;
        }

        Object right = operand2.eval(rowSet);
        if (right == null) {
            return null;
        }

        if (!(left instanceof Number)) {
            Class<?> leftClass = left.getClass();
            throw new RuntimeException("Cannot plus tow value because left(" + leftClass + ") isn't Number");
        }
        if (!(right instanceof Number)) {
            Class<?> rightClass = right.getClass();
            throw new RuntimeException("Cannot plus tow value because right(" + rightClass + ") isn't Number");
        }

        DataType leftType = DataType.getByClass(left.getClass());
        DataType rightType = DataType.getByClass(right.getClass());
        return (T) evalNumeric((Number) left, (Number) right, leftType.compareTo(rightType) > 0 ? leftType : rightType);
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        Object result = eval(rowSet);
        return DataType.getByClass(result.getClass());
    }

    /**
     * 评估 Number 表达式计算结果
     *
     * @param left 左操作数
     * @param right 右操作数
     * @param resultType 结果类型
     * @return 表达式结果
     */
    protected abstract Number evalNumeric(Number left, Number right, DataType resultType);
}
