package com.martin.calcite.sql.parser.expression.math;

import com.martin.calcite.sql.parser.expression.BiExpressionWithType;
import com.martin.calcite.sql.parser.expression.Expression;

/**
 * MultiExpression <br>
 * 乘法表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class MultiFunction<T> extends BiExpressionWithType<T> {

    public MultiFunction() {
    }

    public MultiFunction(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    @Override
    public T eval(Object object) {
        return null;
    }
}