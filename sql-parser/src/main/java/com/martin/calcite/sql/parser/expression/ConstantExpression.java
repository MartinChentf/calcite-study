package com.martin.calcite.sql.parser.expression;

import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * ConstantExpression <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ConstantExpression<T> implements Expression<T> {

    private T value;
    private DataType type;

    public ConstantExpression() {
        // NOP
    }

    private ConstantExpression(T value, DataType type) {
        this.value = value;
        this.type = type;
    }

    public static ConstantExpression<?> create(Object value, DataType type) {
        return new ConstantExpression<>(value, type);
    }

    @Override
    public T eval(RowSet rowSet) {
        return value;
    }

    @Override
    public DataType evalType(RowSet rowSet) {
        return type;
    }

    public T getValue() {
        return value;
    }

    public DataType getType() {
        return type;
    }
}
