package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.VariExpression;
import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * OrPredicate <br>
 * 断言表达式：OR
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class OrPredicate extends VariExpression<Boolean> {

    public OrPredicate() {
        // NOP
    }

    private OrPredicate(Expression<?>... operands) {
        super(operands);
    }

    public static OrPredicate create(Expression<?>... operands) {
        return new OrPredicate(operands);
    }

    @Override
    public Boolean eval(RowSet rowSet) {
        return TernaryLogic.or(rowSet, operands);
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return DataType.BOOLEAN;
    }
}
