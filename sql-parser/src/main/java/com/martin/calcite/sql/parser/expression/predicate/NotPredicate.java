package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * NotExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class NotPredicate extends UniExpression<Boolean> {

    public NotPredicate() {
        // NOP
    }

    private NotPredicate(Expression<?> operand) {
        super(operand);
    }

    public static NotPredicate create(Expression<?> operand) {
        return new NotPredicate(operand);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.not((Boolean) operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
