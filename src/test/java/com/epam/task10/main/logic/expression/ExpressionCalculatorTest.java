package com.epam.task10.main.logic.expression;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {

    private final ExpressionCalculator calculator = new ExpressionCalculator();

    @Test
    public void testCalculateShouldReturnCorrectResultWhenDivided() {
        //give
        String expression = "5 5 /";
        //when
        int actual = calculator.calculate(expression);
        //then
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenSubtracted() {
        //give
        String expression = "5 5 -";
        //when
        int actual = calculator.calculate(expression);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenMultiplied() {
        //give
        String expression = "5 5 *";
        //when
        int actual = calculator.calculate(expression);
        //then
        Assert.assertEquals(25, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenSummed() {
        //give
        String expression = "5 5 +";
        //when
        int actual = calculator.calculate(expression);
        //then
        Assert.assertEquals(10, actual);
    }
}