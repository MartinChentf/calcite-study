package com.martin.calcite.sql.parser.expression.predicate;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.VariExpression;

/**
 * OrPredicate <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class OrPredicate extends VariExpression<Boolean> {

    public OrPredicate() {
    }

    public OrPredicate(Expression<?>... operands) {
        super(operands);
    }

    @Override
    public Boolean eval(Object object) {
        return null;
    }
}
