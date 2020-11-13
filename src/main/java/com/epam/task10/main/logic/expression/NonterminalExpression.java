package com.epam.task10.main.logic.expression;

public class NonterminalExpression implements MathExpression {

    private final int number;

    public NonterminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}