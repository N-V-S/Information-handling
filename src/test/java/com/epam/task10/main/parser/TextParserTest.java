package com.epam.task10.main.parser;

import com.epam.task10.main.model.Component;
import com.epam.task10.main.model.Composite;
import com.epam.task10.main.model.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class TextParserTest {

    @Test
    public void testParseShouldReturnComponentWithChildrenParagraphsWhenGetText() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(paragraphParser);
        String inputData = "It [17 3 +] fact. It [17 3 +] fact.\nIt [17 3 +] fact. It [17 3 +] fact.";
        when(textParser.parse(inputData)).thenAnswer(invocation -> Leaf.word((String)invocation.getArguments()[0]));
        Composite expected = new Composite(Arrays.asList(Leaf.word("It [17 3 +] fact. It [17 3 +] fact.\n"), Leaf.word("It [17 3 +] fact. It [17 3 +] fact.")));
        //when
        Component actual = textParser.parse(inputData);
        //then
        Assert.assertEquals(expected, actual);
    }
}