package com.martin.calcite.sql.parser.metadata;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * RowSetMetadata <br>
 * 行集元数据信息
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public class RowSetMetadata implements Serializable {
    public static final int COLUMN_NOT_FOUND = -1;

    private final Field[] fields;
    private final Map<String, Integer> nameToIndex;

    public RowSetMetadata(Field[] fields) {
        Objects.requireNonNull(fields, "fields must not null");

        this.fields = Arrays.copyOf(fields, fields.length);
        this.nameToIndex = new HashMap<>(fields.length);
        for (int i = 0; i < this.fields.length; i++) {
            this.nameToIndex.put(fields[i].getColumnName(), i);
            fields[i].setCollationIndex(i);
        }
    }

    @SuppressWarnings("CopyConstructorMissesField")
    RowSetMetadata(RowSetMetadata metadata) {
        this(metadata.fields);
    }

    public int getColumnCount() {
        return this.fields.length;
    }

    public String getColumnName(int column) {
        Field field = getField(column);
        return field.getColumnName();
    }

    public String getSchemaName(int column) {
        Field field = getField(column);
        return field.getDatabaseName();
    }

    public String getTableName(int column) {
        Field field = getField(column);
        return field.getTableName();
    }

    public int getColumnType(int column) {
        Field field = getField(column);
        return field.getDataType().getJdbcType();
    }

    public String getColumnTypeName(int column) {
        Field field = getField(column);
        return field.getDataType().getClassName();
    }

    public int getColumnIndex(String columnName) {
        return nameToIndex.getOrDefault(columnName, COLUMN_NOT_FOUND);
    }

    private Field getField(int column) {
        if (column < 0 || column > fields.length - 1) {
            throw new IndexOutOfBoundsException("Column Index out of range, field count:" + this.fields.length);
        }
        return fields[column];
    }
}
