package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.UniExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * IsTruePredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class IsTruePredicate extends UniExpression<Boolean> {

    public IsTruePredicate() {
        // NOP
    }

    private IsTruePredicate(Expression<?> expression) {
        super(expression);
    }

    public static IsTruePredicate create(Expression<?> expression) {
        return new IsTruePredicate(expression);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.isTrue((Boolean) operand.eval(rowSet));
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
