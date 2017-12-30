package com.home;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String beginWord;
    private String endWord;
    private String nextWord;
    private List<String> fullList;
    private List<String> shortList;

    @Before
    public void before() throws Exception {
        beginWord = "test";
        endWord = "nett";
        nextWord = "nest";

        fullList = Arrays.asList(nextWord, endWord);
        shortList = Collections.singletonList(nextWord);
    }

    @Test
    public void restoreChains() throws Exception {
        final List<List<Integer>> chains = Arrays.asList(
                Collections.singletonList(-1),
                Collections.singletonList(0)
        );

        final List<List<String>> expected = Collections.singletonList(
                Arrays.asList(beginWord, nextWord, endWord)
        );

        final List<List<String>> result = (new Solution()).restoreChains(chains, 1, beginWord,
                fullList, new ArrayList<>(), new ArrayList<>());

        assertEquals(expected, result);
    }

    @Test
    public void restoreChainsShortestChain() throws Exception {
        final List<List<Integer>> chains = Collections.singletonList(
                Collections.singletonList(-1)
        );

        final List<List<String>> expected = Collections.singletonList(
                Arrays.asList(beginWord, nextWord)
        );

        final List<List<String>> result = (new Solution()).restoreChains(chains, 0, beginWord,
                shortList, new ArrayList<>(), new ArrayList<>());

        assertEquals(expected, result);
    }

    @Test
    public void restoreChainException() throws Exception {
        thrown.expect(IndexOutOfBoundsException.class);

        (new Solution()).restoreChains(new ArrayList<>(), 1, beginWord, fullList,
                new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void differInOneLetter() throws Exception {
        final String first = beginWord;
        final String second = nextWord;

        final boolean result = (new Solution()).differInOneLetter(first, second);

        assertEquals(true, result);
    }

    @Test
    public void differInOneLetterSameWords() throws Exception {
        final String first = beginWord;
        final String second = beginWord;

        final boolean result = (new Solution()).differInOneLetter(first, second);

        assertEquals(false, result);
    }

    @Test
    public void differInMoreThanOneLetter() throws Exception {
        final String first = beginWord;
        final String second = endWord;

        final boolean result = (new Solution()).differInOneLetter(first, second);

        assertEquals(false, result);
    }

    @Test
    public void differInOneLetterException() throws Exception {
        thrown.expect(StringIndexOutOfBoundsException.class);

        final String first = beginWord;
        final String second = "";

        (new Solution()).differInOneLetter(first, second);
    }
}