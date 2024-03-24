package com.martin.calcite.sql.parser.metadata;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;

/**
 * DataType <br>
 * 支持的数据类型
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public enum DataType {
    // NULL
    NULL("NULL", Types.NULL, Object.class),
    // 数值类
    BIT("BIT", Types.BIT, Boolean.class),
    BOOLEAN("BOOLEAN", Types.BOOLEAN, Boolean.class),
    TINYINT("TINYINT", Types.TINYINT, Integer.class),
    SMALLINT("SMALLINT", Types.SMALLINT, Integer.class),
    INTEGER("INTEGER", Types.INTEGER, Integer.class),
    BIGINT("BIGINT", Types.BIGINT, Long.class),
    FLOAT("FLOAT", Types.FLOAT, Float.class),
    DOUBLE("DOUBLE", Types.DOUBLE, Double.class),
    DECIMAL("DECIMAL", Types.DECIMAL, BigDecimal.class),
    // 时间类
    DATE("DATE", Types.DATE, Date.class),
    TIME("TIME", Types.TIME, Time.class),
    TIMESTAMP("TIMESTAMP", Types.TIMESTAMP, Timestamp.class),
    DATATIME("DATETIME", Types.TIMESTAMP, LocalDateTime.class),
    // 字符串类
    VARCHAR("VARCHAR", Types.VARCHAR, String.class),
    CHAR("CHAR", Types.CHAR, String.class),
    // 未知
    UNKNOWN("UNKNOWN", Types.OTHER, null);

    public static DataType getByJdbcType(int jdbcType) {
        switch (jdbcType) {
            case Types.BIGINT:
                return BIGINT;
            case Types.BIT:
                return BIT;
            case Types.BOOLEAN:
                return BOOLEAN;
            case Types.CHAR:
            case Types.NCHAR: // TODO check that it's correct
                return CHAR;
            case Types.DATE:
                return DATE;
            case Types.DECIMAL:
            case Types.NUMERIC:
                return DECIMAL;
            case Types.DOUBLE:
            case Types.FLOAT:
                return DOUBLE;
            case Types.INTEGER:
                return INTEGER;
            case Types.NULL:
                return NULL;
            case Types.REAL:
                return FLOAT;
            case Types.SMALLINT:
                return SMALLINT;
            case Types.TIME:
                return TIME;
            case Types.TIMESTAMP:
                return TIMESTAMP;
            case Types.TINYINT:
                return TINYINT;
            case Types.VARCHAR:
            case Types.NVARCHAR: // TODO check that it's correct
            case Types.DATALINK: // TODO check that it's correct
            case Types.SQLXML: // TODO check that it's correct
                return VARCHAR;
                // TODO check next types
            case Types.ARRAY:
            case Types.DISTINCT:
            case Types.OTHER:
            case Types.REF:
            case Types.ROWID:
            case Types.STRUCT:
            default:
                return UNKNOWN;
        }
    }

    public static DataType getByClass(Class<?> clazz) {
        switch (clazz.getName()) {
            case "java.lang.Boolean":
                return BOOLEAN;
            case "java.lang.Integer":
                return INTEGER;
            case "java.lang.Long":
                return BIGINT;
            case "java.lang.Float":
                return FLOAT;
            case "java.lang.Double":
                return DOUBLE;
            case "java.math.BigDecimal":
                return DECIMAL;
            case "java.sql.Date":
                return DATE;
            case "java.sql.Time":
                return TIME;
            case "java.util.Date":
            case "java.sql.Timestamp":
                return TIMESTAMP;
            case "java.time.LocalDateTime":
                return DATATIME;
            case "java.lang.String":
                return VARCHAR;
            default:
                return UNKNOWN;
        }
    }

    private final String name;
    private final int jdbcType;
    private final Class<?> javaClass;

    DataType(String name, int jdbcType, Class<?> javaClass) {
        this.name = name;
        this.jdbcType = jdbcType;
        this.javaClass = javaClass;
    }

    public String getName() {
        return name;
    }

    public int getJdbcType() {
        return jdbcType;
    }

    public String getClassName() {
        if (this.javaClass == null) {
            return "[B";
        }
        return this.javaClass.getName();
    }
}
