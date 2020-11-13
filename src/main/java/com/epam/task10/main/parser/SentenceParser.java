package com.epam.task10.main.parser;

import com.epam.task10.main.model.Component;
import com.epam.task10.main.model.Leaf;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private static final String WORD_PATTERN = "[\\w!\"'().:;?-]+";
    private static final String EXPRESSION_PATTERN = "[^\\]][\\d \\+\\-\\*\\/]+[\\]$]";
    private static final String LEXEME_PATTERN = WORD_PATTERN + "|" + EXPRESSION_PATTERN;

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public String getPattern() {
        return LEXEME_PATTERN;
    }

    @Override
    protected void process(List<Component> children, String componentValue) {
        Leaf component = isExpression(componentValue) ? Leaf.expression(componentValue) : Leaf.word(componentValue);
        children.add(component);
    }

    private boolean isExpression(String lexeme) {
        Pattern pattern = Pattern.compile(EXPRESSION_PATTERN);
        Matcher matcher = pattern.matcher(lexeme);
        return matcher.matches();
    }
}