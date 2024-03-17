package com.martin.calcite.sql.parser.expression.predicate;

/**
 * ComparisonMode <br>
 * 比较模式
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public enum ComparisonMode {
    /** 比较模式 */
    EQUALS(0),
    NOT_EQUALS(1),
    GREATER_THAN(2),
    GREATER_THAN_OR_EQUAL(3),
    LESS_THAN(4),
    LESS_THAN_OR_EQUAL(5);

    private final int id;

    ComparisonMode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
