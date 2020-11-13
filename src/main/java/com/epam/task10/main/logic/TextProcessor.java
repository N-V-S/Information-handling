package com.epam.task10.main.logic;

import com.epam.task10.main.logic.expression.ExpressionCalculator;
import com.epam.task10.main.model.Component;
import com.epam.task10.main.model.Composite;
import com.epam.task10.main.model.Leaf;
import com.epam.task10.main.model.LeafType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {

    private static final int EXPRESSION_START_INDEX = 1;

    private static final String PARAGRAPH_SEPARATOR = "\n";
    private static final String LEXEME_SEPARATOR = " ";

    private final ExpressionCalculator calculator = new ExpressionCalculator();

    public Component calculateExpression(Component component) {
        List<Component> componentChildren = component.getChildren();
        if (componentChildren.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return lexemeOperations(leaf);
        }
        List<Component> calculatedComponents = new ArrayList<>();
        for(Component child : componentChildren) {
            Component calculatedExpression = calculateExpression(child);
            calculatedComponents.add(calculatedExpression);
        }
        return new Composite(calculatedComponents);
    }

    private Leaf lexemeOperations(Leaf leaf) {
        LeafType leafType = leaf.getType();
        if (leafType == LeafType.WORD) {
            return leaf;
        }
        String componentValue = leaf.getValue();
        int valueLength = componentValue.length();
        String expressionValue = componentValue.substring(EXPRESSION_START_INDEX, valueLength - 1);
        int expressionResult = calculator.calculate(expressionValue);
        return leaf.word(Integer.toString(expressionResult));
    }

    public String restore(Component rootComponent) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : rootComponent.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {
                    String value = ((Leaf) lexeme).getValue();
                    text.append(value);
                    text.append(LEXEME_SEPARATOR);
                }
            }
            text.append(PARAGRAPH_SEPARATOR);
        }
        return text.toString();
    }

    public Component sortParagraphsBySentencesNumber(Component rootComponent) {
        List<Component> paragraphs = new ArrayList<>(rootComponent.getChildren());
        paragraphs.sort(new Comparator<Component>() {
                @Override
                public int compare(Component first, Component second) {
                    List<Component> firstSentences = first.getChildren();
                    List<Component> secondSentences = second.getChildren();
                    return firstSentences.size() - secondSentences.size();
                }
            });
        return new Composite(paragraphs);
    }

    public Component sortLexemesInSentenceByLength(Component rootComponent) {
        List<Component> paragraphs = new ArrayList<>();
        for (Component paragraph : rootComponent.getChildren()) {
            List<Component> sentences = new ArrayList<>();
            for (Component sentence : paragraph.getChildren()) {
                List<Component> lexemes = new ArrayList<>(sentence.getChildren());
                lexemes.sort(new Comparator<Component>() {
                    @Override
                    public int compare(Component first, Component second) {
                        String firstValue = ((Leaf) first).getValue();
                        String secondValue = ((Leaf) second).getValue();
                        return firstValue.length() - secondValue.length();
                    }
                });
                sentences.add(new Composite(lexemes));
            }
            paragraphs.add(new Composite(sentences));
        }
        return new Composite(paragraphs);
    }
}