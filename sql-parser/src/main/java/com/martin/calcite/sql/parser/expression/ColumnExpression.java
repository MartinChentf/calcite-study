package com.martin.calcite.sql.parser.expression;

import com.martin.calcite.sql.parser.expression.type.QueryDataType;

/**
 * ColumnExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ColumnExpression<T> implements Expression<T> {

    private String name;
    private QueryDataType type;

    @Override
    public T eval(Object object) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueryDataType getType() {
        return type;
    }

    public void setType(QueryDataType type) {
        this.type = type;
    }
}
