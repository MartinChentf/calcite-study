package com.martin.calcite.sql.parser.metadata;

import java.util.Objects;

/**
 * HeapRowSet <br>
 * 行集实现类，数据存储在 JVM 堆中
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public class HeapRowSet implements RowSet {

    private final Object[] row;
    private final RowSetMetadata metadata;

    public HeapRowSet(Object[] row, RowSetMetadata metadata) {
        this.row = Objects.requireNonNull(row, "row must not be null");
        this.metadata = Objects.requireNonNull(metadata, "metadata must not be null");

        if (!Objects.equals(row.length, metadata.getColumnCount())) {
            throw new IllegalArgumentException("the length of row is not equal the column count of metadata");
        }
    }

    @Override
    public Object get(int column) {
        if (column < 0 || column > row.length - 1) {
            throw new IndexOutOfBoundsException("Column Index out of range, field count:" + this.row.length);
        }
        return row[column];
    }

    @Override
    public Object get(String columnName) {
        int columnIndex = metadata.getColumnIndex(columnName);
        if (RowSetMetadata.COLUMN_NOT_FOUND == columnIndex) {
            throw new IllegalArgumentException("Column " + columnName + " not found");
        }
        return get(columnIndex);
    }

    @Override
    public RowSetMetadata getMetadata() {
        return new RowSetMetadata(metadata);
    }
}
