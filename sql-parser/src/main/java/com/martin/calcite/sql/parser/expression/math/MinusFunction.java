package com.martin.calcite.sql.parser.expression.math;

import com.martin.calcite.sql.parser.expression.BiExpressionWithType;
import com.martin.calcite.sql.parser.expression.Expression;

/**
 * MinusExpression <br>
 * 减法表达式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class MinusFunction<T> extends BiExpressionWithType<T> {

    public MinusFunction() {
    }

    public MinusFunction(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    @Override
    public T eval(Object object) {
        return null;
    }
}
