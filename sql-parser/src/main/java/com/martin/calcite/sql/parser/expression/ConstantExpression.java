package com.martin.calcite.sql.parser.expression;

import com.martin.calcite.sql.parser.expression.type.QueryDataType;

/**
 * ConstantExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ConstantExpression<T> implements Expression<T> {

    private T value;
    private QueryDataType type;

    @Override
    public T eval(Object object) {
        return null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public QueryDataType getType() {
        return type;
    }

    public void setType(QueryDataType type) {
        this.type = type;
    }
}
