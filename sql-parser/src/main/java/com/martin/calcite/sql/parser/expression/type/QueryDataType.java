package com.martin.calcite.sql.parser.expression.type;

import java.sql.Types;

/**
 * QueryDataType <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class QueryDataType {

    public static final QueryDataType BOOLEAN = new QueryDataType(Types.BOOLEAN);
    public static final QueryDataType TINYINT = new QueryDataType(Types.TINYINT);
    public static final QueryDataType SMALLINT = new QueryDataType(Types.SMALLINT);
    public static final QueryDataType INTEGER = new QueryDataType(Types.INTEGER);
    public static final QueryDataType BIGINT = new QueryDataType(Types.BIGINT);
    public static final QueryDataType DECIMAL = new QueryDataType(Types.DECIMAL);
    public static final QueryDataType FLOAT = new QueryDataType(Types.FLOAT);
    public static final QueryDataType REAL = new QueryDataType(Types.REAL);
    public static final QueryDataType DOUBLE = new QueryDataType(Types.DOUBLE);

    public static final QueryDataType DATE = new QueryDataType(Types.DATE);
    public static final QueryDataType TIME = new QueryDataType(Types.TIME);
    public static final QueryDataType TIMESTAMP = new QueryDataType(Types.TIMESTAMP);

    public static final QueryDataType CHAR = new QueryDataType(Types.DOUBLE);
    public static final QueryDataType VARCHAR = new QueryDataType(Types.VARCHAR);

    private final int jdbcOriginal;

    public QueryDataType(int jdbcOriginal) {
        this.jdbcOriginal = jdbcOriginal;
    }

    public int getJdbcOriginal() {
        return jdbcOriginal;
    }
}
