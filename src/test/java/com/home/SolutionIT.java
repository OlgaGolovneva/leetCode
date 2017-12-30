package com.home;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionIT {

    @Test
    public void testMultipleChains() throws Exception {

        final String beginWord = TestData.DEFAULT_BEGIN_WORD;
        final String endWord = TestData.DEFAULT_END_WORD;
        final List<String> wordList = TestData.FULL_WORD_LIST;

        final List<List<String>> result = (new Solution()).findLadders(beginWord, endWord, wordList);

        assertEquals(result, TestData.FULL_WORD_LIST_RESULT);

    }

    @Test
    public void testEndWordMissing() throws Exception {

        final String beginWord = TestData.DEFAULT_BEGIN_WORD;
        final String endWord = TestData.DEFAULT_END_WORD;
        final List<String> wordList = TestData.MISSING_WORD_LIST;

        final List<List<String>> result = (new Solution()).findLadders(beginWord, endWord, wordList);

        assertEquals(result, TestData.MISSING_WORD_LIST_RESULT);

    }

    @Test
    public void testShortestChain() throws Exception {

        final String beginWord = TestData.DEFAULT_BEGIN_WORD;
        final String endWord = TestData.CLOSEST_END_WORD;
        final List<String> wordList = TestData.MISSING_WORD_LIST;

        final List<List<String>> result = (new Solution()).findLadders(beginWord, endWord, wordList);

        assertEquals(result, TestData.SHORTEST_LIST_RESULT);

    }

    @Test
    public void testDiamondChains() throws Exception {

        final String beginWord = TestData.DIAMOND_BEGIN_WORD;
        final String endWord = TestData.DIAMOND_END_WORD;
        final List<String> wordList = TestData.DIAMOND_WORD_LIST;

        final List<List<String>> result = (new Solution()).findLadders(beginWord, endWord, wordList);

        assertEquals(result, TestData.DIAMOND_WORD_LIST_RESULT);

    }

    private static String intToWord(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int d = n % 10;
            n = n / 10;
            builder.append((char)(d + 'a'));
        }
        return  builder.toString();
    }

    @Test
    public void testLarge() throws Exception {

        final String beginWord = "aaa";
        final String endWord = "bbb";
        final List<String> wordList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            wordList.add(intToWord(i));
        }

        final List<List<String>> result = (new Solution()).findLadders(beginWord, endWord, wordList);

        assertEquals(6, result.size());

    }
}
