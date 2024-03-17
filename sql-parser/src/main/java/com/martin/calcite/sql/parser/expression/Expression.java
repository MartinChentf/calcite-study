package com.martin.calcite.sql.parser.expression;

/**
 * Expression <br>
 * 表达式接口
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public interface Expression<T> {

    /**
     * 评估表达式结果
     *
     * @param object <br>
     * @return 表达式结果
     */
    T eval(Object object);
}
