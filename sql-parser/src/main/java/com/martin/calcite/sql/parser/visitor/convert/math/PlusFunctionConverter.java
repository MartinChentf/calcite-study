package com.martin.calcite.sql.parser.visitor.convert.math;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.math.PlusFunction;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * PlusFunctionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class PlusFunctionConverter extends AbstractExpressionConverter<PlusFunction<?>> {
    @Override
    protected PlusFunction<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return new PlusFunction<>(operands.get(0), operands.get(1));
    }
}
