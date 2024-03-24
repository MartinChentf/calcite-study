package com.martin.calcite.sql.parser.metadata;

import java.io.Serializable;

/**
 * Field <br>
 * 描述行集元数据的字段
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public class Field implements Serializable {

    private int collationIndex;

    private final String databaseName;
    private final String tableName;
    private final String columnName;
    private final DataType dataType;

    public Field(String databaseName, String tableName, String columnName, int collationIndex, DataType dataType) {
        this.collationIndex = collationIndex;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.columnName = columnName;
        this.dataType = dataType == null ? DataType.UNKNOWN: dataType;
    }

    public Field(String tableName, String columnName, int collationIndex, DataType dataType) {
        this(null, tableName, columnName, collationIndex, dataType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("dbName=");
        sb.append(this.getDatabaseName());
        sb.append(",tableName=");
        sb.append(this.getTableName());
        sb.append(",columnName=");
        sb.append(this.getColumnName());
        sb.append(",dataType=");
        DataType dataType = getDataType();
        if (dataType.equals(DataType.UNKNOWN)) {
            sb.append("Unknown Data Type");
        } else {
            sb.append(dataType.getName());
        }
        sb.append(",sqlType=");
        sb.append(dataType.getJdbcType());
        sb.append(", collationIndex=");
        sb.append(this.getCollationIndex());
        return sb.toString();
    }

    public int getCollationIndex() {
        return collationIndex;
    }

    public void setCollationIndex(int collationIndex) {
        this.collationIndex = collationIndex;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public DataType getDataType() {
        return dataType;
    }
}
