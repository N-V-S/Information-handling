package com.epam.task10.main.parser;

import com.epam.task10.main.model.Composite;
import com.epam.task10.main.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    @Test
    public void testParseShouldReturnComponentWithChildrenWordsAndExpressionWhenGetText() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);
        String inputData = "It [17 3 +] fact.";
        Composite expected = new Composite(Arrays.asList(Leaf.word("It"), Leaf.expression("[17 3 +]"), Leaf.word("fact.")));
        //when
        Composite actual = (Composite)sentenceParser.parse(inputData);
        //then
        Assert.assertEquals(expected, actual);
    }
}