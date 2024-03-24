package com.martin.calcite.sql.parser;

import org.apache.calcite.avatica.util.Casing;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.SqlParser.Config;

import com.martin.calcite.sql.parser.expression.Expression;
import com.martin.calcite.sql.parser.expression.ExpressionList;
import com.martin.calcite.sql.parser.visitor.QuerySegmentType;
import com.martin.calcite.sql.parser.visitor.SqlToExprVisitor;

/**
 * ExpressionUtil <br>
 * 表达式工具类
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ExpressionUtil {

    /**
     * 解析 select 字段列表，并转换成表达式
     *
     * @param columns 字段列表
     * @return 表达式
     */
    public static ExpressionList parseSelectList(String... columns) {
        String sql = "SELECT " + String.join(",", columns);
        return (ExpressionList) convertSql2Expr(sql, QuerySegmentType.SELECT);
    }

    /**
     * 解析 where 条件，并转换成表达式
     *
     * @param condition 判断条件
     * @return 表达式
     */
    public static Expression<?> parseWhereCondition(String condition) {
        String sql = "SELECT * FROM T_TABLE WHERE " + condition;
        return convertSql2Expr(sql, QuerySegmentType.WHERE);
    }

    /**
     * 解析 group 分组条件，并转换成表达式
     *
     * @param groupBy 分组列表
     * @return 表达式
     */
    public static ExpressionList parseGroupBy(String... groupBy) {
        String sql = "SELECT * FROM T_TABLE GROUP BY " + String.join(",", groupBy);
        return (ExpressionList) convertSql2Expr(sql, QuerySegmentType.GROUP);
    }

    /**
     * 解析 order by 排序条件，并转换成表达式
     *
     * @param orderBy 排序字段
     * @return 表达式
     */
    public static ExpressionList parseOrderList(String... orderBy) {
        String sql = "SELECT * FROM T_TABLE ORDER BY " + String.join(",", orderBy);
        return (ExpressionList) convertSql2Expr(sql, QuerySegmentType.ORDER);
    }

    /**
     * 解析 having 条件，并转换成表达式
     *
     * @param condition 判断条件
     * @return 表达式
     */
    public static Expression<?> parseHavingCondition(String condition) {
        String sql = "SELECT * FROM T_TABLE HAVING " + condition;
        return convertSql2Expr(sql, QuerySegmentType.HAVING);
    }

    private static Expression<?> convertSql2Expr(String sql, QuerySegmentType type) {
        try {
            SqlNode sqlNode = parserSql(sql);

            SqlToExprVisitor visitor = new SqlToExprVisitor(type);
            return sqlNode.accept(visitor);
        } catch (SqlParseException e) {
            throw new IllegalStateException("字段解析异常", e);
        }
    }

    private static SqlNode parserSql(String sql) throws SqlParseException {
        Config config = SqlParser.config().withCaseSensitive(false).withUnquotedCasing(Casing.UNCHANGED);
        SqlParser sqlParser = SqlParser.create(sql, config);
        return sqlParser.parseStmt();
    }
}
