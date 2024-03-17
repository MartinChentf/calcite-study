package com.martin.calcite.sql.parser;

import com.martin.calcite.sql.parser.expression.Expression;

/**
 * SqlParserTest <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class SqlParserTest {
    public static void main(String[] args) {
        // Expression<?> expression = ExpressionUtil.parseSelectList("col1, col2 + col3, col4 / 3 - 2, col5 * 3");
        // Expression<?> expression = ExpressionUtil.parseSelectList("*");
        Expression<?> expression1 = ExpressionUtil.parseWhereCondition("col1 > 10 or not (col3 is not null) and col4 is true and col5 is not false");
        Expression<?> expression5 = ExpressionUtil.parseWhereCondition("col1 not like '%work'");
        Expression<?> expression2 = ExpressionUtil.parseGroupBy("col1, col2");
        Expression<?> expression3 = ExpressionUtil.parseHavingCondition("col1 = '123456'");
        Expression<?> expression4 = ExpressionUtil.parseOrderList("col1 asc, col2 desc, col3 nulls first, col4 desc nulls last");
    }
}
