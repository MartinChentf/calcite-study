package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsFalsePredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsFalsePredicate extends UniExpression<Boolean> {

    public IsFalsePredicate() {
        // NOP
    }

    private IsFalsePredicate(Expression<?> expression) {
        super(expression);
    }

    public static IsFalsePredicate create(Expression<?> expression) {
        return new IsFalsePredicate(expression);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isFalse((Boolean) operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
