package com.epam.task10.main.logic.expression;

public class TerminalExpressionDivide implements MathExpression {

    @Override
    public void interpret(Context context) {
        int divisible = context.popValue();
        int divisor = context.popValue();
        context.pushValue(divisible / divisor);
    }
}