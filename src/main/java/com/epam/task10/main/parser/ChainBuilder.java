package com.epam.task10.main.parser;

public class ChainBuilder {

    public Parser build(){
        SentenceParser sentenceParser = new SentenceParser(null);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}