package com.martin.calcite.sql.parser.visitor.convert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.calcite.sql.SqlKind;

import com.martin.calcite.sql.parser.visitor.convert.math.DivideFunctionConverter;
import com.martin.calcite.sql.parser.visitor.convert.math.MinusFunctionConverter;
import com.martin.calcite.sql.parser.visitor.convert.math.MultiFunctionConverter;
import com.martin.calcite.sql.parser.visitor.convert.math.PlusFunctionConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.AndPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.ComparisonPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsFalsePredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsNotFalsePredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsNotNullPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsNotTruePredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsNullPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.IsTruePredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.NotPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.predicate.OrPredicateConverter;
import com.martin.calcite.sql.parser.visitor.convert.string.LikeFunctionConverter;

/**
 * ExpressionConverterManager <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ExpressionConverterManager {

    private static final Map<SqlKind, Class<? extends ExpressionConverter<?>>> CONVERTER_CLASS_MAP;
    private static final Map<SqlKind, ExpressionConverter<?>> CONVERTER_MAP;

    static {
        Map<SqlKind, Class<? extends ExpressionConverter<?>>> map = new HashMap<>();

        map.put(SqlKind.PLUS, PlusFunctionConverter.class);
        map.put(SqlKind.MINUS, MinusFunctionConverter.class);
        map.put(SqlKind.TIMES, MultiFunctionConverter.class);
        map.put(SqlKind.DIVIDE, DivideFunctionConverter.class);

        map.put(SqlKind.NOT, NotPredicateConverter.class);
        map.put(SqlKind.AND, AndPredicateConverter.class);
        map.put(SqlKind.OR, OrPredicateConverter.class);

        map.put(SqlKind.EQUALS, ComparisonPredicateConverter.class);
        map.put(SqlKind.NOT_EQUALS, ComparisonPredicateConverter.class);
        map.put(SqlKind.LESS_THAN, ComparisonPredicateConverter.class);
        map.put(SqlKind.LESS_THAN_OR_EQUAL, ComparisonPredicateConverter.class);
        map.put(SqlKind.GREATER_THAN, ComparisonPredicateConverter.class);
        map.put(SqlKind.GREATER_THAN_OR_EQUAL, ComparisonPredicateConverter.class);

        map.put(SqlKind.IS_TRUE, IsTruePredicateConverter.class);
        map.put(SqlKind.IS_FALSE, IsFalsePredicateConverter.class);
        map.put(SqlKind.IS_NOT_TRUE, IsNotTruePredicateConverter.class);
        map.put(SqlKind.IS_NOT_FALSE, IsNotFalsePredicateConverter.class);
        map.put(SqlKind.IS_NULL, IsNullPredicateConverter.class);
        map.put(SqlKind.IS_NOT_NULL, IsNotNullPredicateConverter.class);

        map.put(SqlKind.DESCENDING, OrderExpressionConverter.class);
        map.put(SqlKind.NULLS_FIRST, NullsFirstExpressionConverter.class);
        map.put(SqlKind.NULLS_LAST, NullsLastExpressionConverter.class);

        map.put(SqlKind.LIKE, LikeFunctionConverter.class);

        CONVERTER_CLASS_MAP = Collections.unmodifiableMap(map);
        CONVERTER_MAP = new ConcurrentHashMap<>(CONVERTER_CLASS_MAP.size());
    }

    public static ExpressionConverter<?> getConverter(SqlKind kind) {
        return CONVERTER_MAP.computeIfAbsent(kind, k -> {
            Class<? extends ExpressionConverter<?>> converterClass = CONVERTER_CLASS_MAP.get(k);
            if (converterClass != null) {
                try {
                    Constructor<? extends ExpressionConverter<?>> constructor = converterClass.getConstructor();
                    return constructor.newInstance();
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalArgumentException("实例化转换器失败：" + converterClass.getName(), e);
                }
            }
            return null;
        });
    }
}
