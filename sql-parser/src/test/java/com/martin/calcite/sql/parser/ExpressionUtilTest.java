package com.martin.calcite.sql.parser; 

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.martin.calcite.sql.parser.expression.ExpressionList;

/** 
* ExpressionUtil Tester. 
* 
* @author Martin
* @date 03/24/2024
* @version 1.0 
*/ 
public class ExpressionUtilTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parseSelectList(String... columns)
     */ 
    @Test
    public void testParseSelectList() throws Exception {
        ExpressionList expressionList = ExpressionUtil.parseSelectList("col1, col2, col3");
        Assert.assertNotNull(expressionList);
        Assert.assertEquals(3, expressionList.size());
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parseWhereCondition(String condition)
     */ 
    @Test
    public void testParseWhereCondition() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parseGroupBy(String... groupBy)
     */ 
    @Test
    public void testParseGroupBy() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parseOrderList(String... orderBy)
     */ 
    @Test
    public void testParseOrderList() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parseHavingCondition(String condition)
     */ 
    @Test
    public void testParseHavingCondition() throws Exception { 
        //TODO: Test goes here... 
    } 


    /** 
     * Test Method for {@link ExpressionUtil#convertSql2Expr(String sql, QuerySegmentType type) 
     */ 
    @Test
    public void testConvertSql2Expr() throws Exception { 
        //TODO: Test goes here... 
        /* 
        try { 
           Method method = ExpressionUtil.getClass().getMethod("convertSql2Expr", String.class, QuerySegmentType.class); 
           method.setAccessible(true); 
           method.invoke(<Object>, <Parameters>); 
        } catch(NoSuchMethodException e) { 
        } catch(IllegalAccessException e) { 
        } catch(InvocationTargetException e) { 
        } 
        */ 
    } 

    /** 
     * Test Method for {@link ExpressionUtil#parserSql(String sql) 
     */ 
    @Test
    public void testParserSql() throws Exception { 
        //TODO: Test goes here... 
        /* 
        try { 
           Method method = ExpressionUtil.getClass().getMethod("parserSql", String.class); 
           method.setAccessible(true); 
           method.invoke(<Object>, <Parameters>); 
        } catch(NoSuchMethodException e) { 
        } catch(IllegalAccessException e) { 
        } catch(InvocationTargetException e) { 
        } 
        */ 
    } 

} 
