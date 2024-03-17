package com.martin.calcite.sql.parser.expression;

import com.martin.calcite.sql.parser.expression.type.QueryDataType;

/**
 * BiExpressionWithType <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public abstract class BiExpressionWithType<T> extends BiExpression<T> {

    private QueryDataType type;

    public BiExpressionWithType() {
    }

    public BiExpressionWithType(Expression<?> operand1, Expression<?> operand2) {
        super(operand1, operand2);
    }

    public QueryDataType getType() {
        return type;
    }

    public void setType(QueryDataType type) {
        this.type = type;
    }
}
