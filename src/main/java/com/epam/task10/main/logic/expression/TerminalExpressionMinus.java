package com.epam.task10.main.logic.expression;

public class TerminalExpressionMinus implements MathExpression {

    @Override
    public void interpret(Context context) {
        int decremented = context.popValue();
        int subtracted = context.popValue();
        context.pushValue(decremented - subtracted);
    }
}
