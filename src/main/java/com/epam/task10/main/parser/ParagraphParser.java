package com.epam.task10.main.parser;

public class ParagraphParser extends AbstractParser {

    private static final String SENTENCE_PATTERN = "[\\S][^.!?]+[.!?\\n]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public String getPattern() {
        return SENTENCE_PATTERN;
    }
}