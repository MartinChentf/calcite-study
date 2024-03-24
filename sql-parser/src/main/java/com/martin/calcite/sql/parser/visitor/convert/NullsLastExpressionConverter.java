package com.martin.calcite.sql.parser.visitor.convert;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.NullsLastExpression;

/**
 * NullsLastExpressionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NullsLastExpressionConverter extends AbstractExpressionConverter<NullsLastExpression<?>> {
    @Override
    protected NullsLastExpression<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return NullsLastExpression.create(operands.get(0));
    }
}
