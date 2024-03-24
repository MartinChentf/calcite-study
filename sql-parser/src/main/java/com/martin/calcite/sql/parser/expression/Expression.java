package com.martin.calcite.sql.parser.expression;

import java.io.Serializable;

import com.martin.calcite.sql.parser.metadata.DataType;
import com.martin.calcite.sql.parser.metadata.RowSet;

/**
 * Expression <br>
 * 表达式接口
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public interface Expression<T> extends Serializable {

    /**
     * 评估表达式结果
     *
     * @param rowSet 行集
     * @return 表达式结果
     */
    default T eval(RowSet rowSet) {
        throw new UnsupportedOperationException();
    }

    /**
     * 评估表达式结果类型
     *
     * @param rowSet 行集
     * @return 行集
     */
    default DataType evalType(RowSet rowSet) {
        throw new UnsupportedOperationException();
    }
}
