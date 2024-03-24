package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsNotFalsePredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotFalsePredicate extends UniExpression<Boolean> {

    public IsNotFalsePredicate() {
        // NOP
    }

    private IsNotFalsePredicate(Expression<?> expression) {
        super(expression);
    }

    public static IsNotFalsePredicate create(Expression<?> expression) {
        return new IsNotFalsePredicate(expression);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isNotFalse((Boolean) operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
