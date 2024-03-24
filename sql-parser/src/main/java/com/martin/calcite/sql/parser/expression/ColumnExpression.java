package com.martin.calcite.sql.parser.expression;

import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * ColumnExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ColumnExpression<T> implements Expression<T> {

    private String name;

    public ColumnExpression() {
        // NOP
    }

    private ColumnExpression(String name) {
        this.name = name;
    }

    public static ColumnExpression<?> create(String name) {
        return new ColumnExpression<>(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T eval(RowSet rowSet) {
        return (T) rowSet.get(name);
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        Object value = rowSet.get(name);
        return DataType.getByClass(value.getClass());
    }

    public String getName() {
        return name;
    }
}
