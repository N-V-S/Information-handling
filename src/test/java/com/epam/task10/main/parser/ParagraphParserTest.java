package com.epam.task10.main.parser;

import com.epam.task10.main.model.Component;
import com.epam.task10.main.model.Composite;
import com.epam.task10.main.model.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    @Test
    public void testParseShouldReturnComponentWithChildrenSentencesWhenGetText() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        String inputData = "It [17 3 +] fact. It [17 3 +] fact.";
        when(paragraphParser.parse(inputData)).thenAnswer(invocation -> Leaf.word((String) invocation.getArguments()[0]));
        Component expected = new Composite(Arrays.asList(Leaf.word("It [17 3 +] fact."), Leaf.word("It [17 3 +] fact.")));
        //when
        Component actual = paragraphParser.parse(inputData);
        //then
        Assert.assertEquals(expected, actual);
    }
}