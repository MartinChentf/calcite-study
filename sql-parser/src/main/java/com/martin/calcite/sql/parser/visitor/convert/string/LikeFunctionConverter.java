package com.martin.calcite.sql.parser.visitor.convert.string;

import java.util.List;

import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.fun.SqlLikeOperator;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.string.LikeFunction;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * LikeFunctionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class LikeFunctionConverter extends AbstractExpressionConverter<LikeFunction> {
    @Override
    protected LikeFunction newInstance(SqlCall call, List<Expression<?>> operands) {
        SqlLikeOperator operator = (SqlLikeOperator) call.getOperator();
        return new LikeFunction(operands.get(0), operands.get(1), operator.isNegated());
    }
}
