package com.martin.calcite.sql.parser.visitor.convert.math;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.math.MinusFunction;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * MinusFunctionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class MinusFunctionConverter extends AbstractExpressionConverter<MinusFunction<?>> {
    @Override
    protected MinusFunction<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return MinusFunction.create(operands.get(0), operands.get(1));
    }
}
