package com.martin.calcite.sql.parser.expression.string;

import com.martin.calcite.sql.parser.expression.BiExpression;
import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * LikeFunction <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class LikeFunction extends BiExpression<Boolean> {

    private boolean negated;

    public LikeFunction() {
        // NOP
    }

    private LikeFunction(Expression<?> operand1, Expression<?> operand2, boolean negated) {
        super(operand1, operand2);
        this.negated = negated;
    }

    public static LikeFunction create(Expression<?> operand1, Expression<?> operand2, boolean negated) {
        return new LikeFunction(operand1, operand2, negated);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        // TODO: 2024/3/24 待实现
        return null;
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }

    public boolean isNegated() {
        return negated;
    }
}
