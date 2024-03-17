package com.martin.calcite.sql.parser.visitor.convert;

import org.apache.calcite.sql.SqlCall;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.visitor.SqlToExprVisitor;

/**
 * ExpressionConverter <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public interface ExpressionConverter<T extends Expression<?>> {

    /**
     * 将 SQLNode 转换成表达式
     *
     * @param call SqlCall 对象
     * @param visitor 访问器
     * @return 表达式
     */
    T convert(SqlCall call, SqlToExprVisitor visitor);
}
