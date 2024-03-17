package com.martin.calcite.sql.parser.visitor.convert.math;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.math.DivideFunction;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * DivideFunctionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class DivideFunctionConverter extends AbstractExpressionConverter<DivideFunction<?>> {
    @Override
    protected DivideFunction<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return new DivideFunction<>(operands.get(0), operands.get(1));
    }
}
