package com.martin.calcite.sql.parser.metadata;

import java.io.Serializable;

/**
 * RowSet <br>
 * 表示一行数据
 *
 * @author Martin
 * @date 2024/3/24
 * @since 1.8
 */
public interface RowSet extends Serializable {

    /**
     * 获取指定列的值
     *
     * @param column 列索引，从 0 开始
     * @return 列值
     */
    Object get(int column);

    /**
     * 获取指定列的值
     *
     * @param columnName 列名
     * @return 列值
     */
    Object get(String columnName);

    /**
     * 获取元数据
     *
     * @return 元数据
     */
    RowSetMetadata getMetadata();
}
