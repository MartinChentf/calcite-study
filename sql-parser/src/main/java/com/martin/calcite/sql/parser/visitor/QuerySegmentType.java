package com.martin.calcite.sql.parser.visitor;

/**
 * QuerySegmentType <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public enum QuerySegmentType {
    SELECT,
    WHERE,
    GROUP,
    ORDER,
    HAVING
}
