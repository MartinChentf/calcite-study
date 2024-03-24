package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.VariExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * AndPredicate <br>
 * 断言表达式：AND
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class AndPredicate extends VariExpression<Boolean> {

    public AndPredicate() {
        // NOP
    }

    private AndPredicate(Expression<?>... operands) {
        super(operands);
    }

    public static AndPredicate create(Expression<?>... operands) {
        return new AndPredicate(operands);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.and(rowSet, operands);
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
