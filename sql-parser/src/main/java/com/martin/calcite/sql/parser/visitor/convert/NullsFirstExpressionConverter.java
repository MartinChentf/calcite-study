package com.martin.calcite.sql.parser.visitor.convert;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.NullsFirstExpression;

/**
 * NullsFirstExpressionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsFirstExpressionConverter extends AbstractExpressionConverter<NullsFirstExpression<?>> {
    @Override
    protected NullsFirstExpression<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return new NullsFirstExpression<>(operands.get(0));
    }
}
