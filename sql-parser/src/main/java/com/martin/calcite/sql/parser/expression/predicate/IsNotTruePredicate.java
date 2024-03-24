package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsNotTruePredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsNotTruePredicate extends UniExpression<Boolean> {

    public IsNotTruePredicate() {
        // NOP
    }

    private IsNotTruePredicate(Expression<?> expression) {
        super(expression);
    }

    public static IsNotTruePredicate create(Expression<?> expression) {
        return new IsNotTruePredicate(expression);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isNotTrue((Boolean) operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
