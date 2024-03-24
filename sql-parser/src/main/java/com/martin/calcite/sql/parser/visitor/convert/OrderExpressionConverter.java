package com.martin.calcite.sql.parser.visitor.convert;

import java.util.List;

import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlKind;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.OrderExpression;

/**
 * OrderExpressionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class OrderExpressionConverter extends AbstractExpressionConverter<OrderExpression<?>> {
    @Override
    protected OrderExpression<?> newInstance(SqlCall call, List<Expression<?>> operands) {
        return OrderExpression.create(operands.get(0), call.getKind() == SqlKind.DESCENDING);
    }
}
