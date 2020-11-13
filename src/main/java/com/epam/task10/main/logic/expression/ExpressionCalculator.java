package com.epam.task10.main.logic.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {

    private static final String SEPARATOR = " ";

    private static final int FIRST_INDEX = 0;

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    private List<MathExpression> parse(String expression) {
        List<MathExpression> expressionList = new ArrayList<>();
        String[] lexemes = expression.split(SEPARATOR);
        for(String lexeme : lexemes) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(FIRST_INDEX);
            switch (temp) {
                case PLUS:
                    expressionList.add(new TerminalExpressionPlus());
                    break;
                case MINUS:
                    expressionList.add(new TerminalExpressionMinus());
                    break;
                case MULTIPLY:
                    expressionList.add(new TerminalExpressionMultiply());
                    break;
                case DIVIDE:
                    expressionList.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        expressionList.add(new NonterminalExpression(number));
                    }
            }
        }
        return expressionList;
    }

    public int calculate(String expression) {
        List<MathExpression> expressionList = parse(expression);
        Context context = new Context();
        for (MathExpression terminal : expressionList) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}