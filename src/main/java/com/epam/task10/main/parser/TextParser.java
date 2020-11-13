package com.epam.task10.main.parser;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH_PATTERN = "[\\S ]+[\\n*]*";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public String getPattern() {
        return PARAGRAPH_PATTERN;
    }
}