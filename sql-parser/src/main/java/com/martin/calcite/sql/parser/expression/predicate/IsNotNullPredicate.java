package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsNotNullPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotNullPredicate extends UniExpression<Boolean> {

    public IsNotNullPredicate() {
        // NOP
    }

    private IsNotNullPredicate(Expression<?> expression) {
        super(expression);
    }

    public static IsNotNullPredicate create(Expression<?> expression) {
        return new IsNotNullPredicate(expression);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isNotNull(operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
