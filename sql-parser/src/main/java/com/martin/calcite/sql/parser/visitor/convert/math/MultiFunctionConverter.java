package com.martin.calcite.sql.parser.visitor.convert.math;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.math.MultiFunction;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * MultiFunctionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class MultiFunctionConverter extends AbstractExpressionConverter<MultiFunction<?>> {
    @Override
    protected MultiFunction<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return new MultiFunction<>(operands.get(0), operands.get(1));
    }
}
