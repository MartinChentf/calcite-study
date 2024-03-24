package com.martin.calcite.sql.parser.visitor.convert.predicate;

import java.util.List;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.predicate.OrPredicate;
import com.martin.calcite.sql.parser.visitor.convert.AbstractExpressionConverter;

/**
 * OrPredicateConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class OrPredicateConverter extends AbstractExpressionConverter<OrPredicate> {

    @Override
    protected OrPredicate newInstance(SqlCall call, List<Expression<?>> operands) {
        return OrPredicate.create(operands.get(0), operands.get(1));
    }
}
