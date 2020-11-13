package com.epam.task10.main.logic.expression;

public class TerminalExpressionPlus implements MathExpression {

    @Override
    public void interpret(Context context) {
        int firstTerm = context.popValue();
        int secondTerm = context.popValue();
        context.pushValue(firstTerm + secondTerm);
    }
}