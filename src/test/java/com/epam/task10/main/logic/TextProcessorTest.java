package com.epam.task10.main.logic;

import com.epam.task10.main.model.Component;

import com.epam.task10.main.model.Composite;
import com.epam.task10.main.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextProcessorTest {

    private final TextProcessor textProcessor = new TextProcessor();

    private static final Leaf FIRST_WORD = Leaf.word("Performance");
    private static final Leaf SECOND_WORD = Leaf.word("powerful");
    private static final Leaf THIRD_WORD = Leaf.word("laptop.");

    private static final Component SENTENCE = new Composite(Arrays.asList(FIRST_WORD, SECOND_WORD, THIRD_WORD));
    private static final Component SORTED_SENTENCE = new Composite(Arrays.asList(THIRD_WORD, SECOND_WORD, FIRST_WORD));

    private static final Component FIRST_PARAGRAPH = new Composite(Arrays.asList(SENTENCE, SENTENCE, SENTENCE));
    private static final Component SECOND_PARAGRAPH = new Composite(Collections.singletonList(SENTENCE));
    private static final Component THIRD_PARAGRAPH = new Composite(Arrays.asList(SENTENCE, SENTENCE));

    private static final Component TEXT = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH, THIRD_PARAGRAPH));

    @Test
    public void testRestoreShouldReturnRestoredTextWhenGetRootTextComponent() {
        //given
        String expected = "Performance powerful laptop. Performance powerful laptop. Performance powerful laptop. \nPerformance powerful laptop. \nPerformance powerful laptop. Performance powerful laptop. \n";
        //when
        String actual = textProcessor.restore(TEXT);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortParagraphsBySentencesNumberShouldReturnSortedParagraphsWhenGetRootTextComponent() {
        //given
        Composite unsortedTextParagraphs = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH, THIRD_PARAGRAPH));
        Component expected = new Composite(Arrays.asList(SECOND_PARAGRAPH, THIRD_PARAGRAPH, FIRST_PARAGRAPH));
        //when
        Component actual = textProcessor.sortParagraphsBySentencesNumber(unsortedTextParagraphs);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortLexemesInSentenceByLengthShouldReturnSortedComponentWhenGetRootTextComponent() {
        //given
        Component expected = new Composite(Arrays.asList(
                new Composite(Arrays.asList(SORTED_SENTENCE, SORTED_SENTENCE, SORTED_SENTENCE)),
                new Composite(Collections.singletonList(SORTED_SENTENCE)),
                new Composite(Arrays.asList(SORTED_SENTENCE, SORTED_SENTENCE))));
        //when
        Component actual = textProcessor.sortLexemesInSentenceByLength(TEXT);
        //then
        Assert.assertEquals(expected, actual);
    }
}