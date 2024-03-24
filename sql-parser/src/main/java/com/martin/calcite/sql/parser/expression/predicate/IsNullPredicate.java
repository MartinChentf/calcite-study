package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsNullPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNullPredicate extends UniExpression<Boolean> {

    public IsNullPredicate() {
        // NOP
    }

    private IsNullPredicate(Expression<?> operand) {
        super(operand);
    }

    public static IsNullPredicate create(Expression<?> operand) {
        return new IsNullPredicate(operand);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isNull(operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
