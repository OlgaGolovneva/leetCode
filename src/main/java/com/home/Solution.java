package com.home;

import java.util.*;

/**
 * Problem statement: https://leetcode.com/problems/word-ladder-ii/description/
 *
 * We build a graph where each vertex corresponds to a word from the input wordList.
 * We add a directed edge from a word w1 to a word w2 iff
 * w1 can be transformed into w2 by changing exactly one character.
 *
 * Now we run a BFS search starting from beginWord, and save auxiliary information
 * so that we could later restore all the shortest paths from beginWord to endWord.
 */

public class Solution
{
    public List<List<String>> findLadders(final String beginWord, final String endWord, final List<String> wordList) {

        // the queue for performing BFS-search on wordlist
        final Queue<Integer> vertices = new LinkedList<>();

        // dist[i] is the minimum number of transformations to get wordList[i] from beginWord
        final int[] dist = new int[wordList.size()];

        // chains[i] contains a list of BFS-search parents of wordList[i]
        final List<List<Integer>> chains = new ArrayList<>();

        // the index of endWord in wordList
        int endIndex = wordList.indexOf(endWord);

        // if the endWord doesn't belong to wordList, then there is no solution
        if (endIndex < 0) {
            return Collections.emptyList();
        }

        // initialize chains
        for (int i = 0; i < wordList.size(); i++) {
            if (differInOneLetter(beginWord, wordList.get(i))) {
                dist[i] = 1;
                vertices.add(i);
                chains.add(i, Collections.singletonList(-1));

                // if beginWord and endWord differ at exactly one character, then return the answer
                if (endIndex == i) {
                    return Collections.singletonList(Arrays.asList(beginWord, endWord));
                }
            } else {
                chains.add(new ArrayList<>());
            }
        }

        // if BFS-search has found endWord, then lastDepth is the last level of BFS-search which must be finished
        int lastDepth = wordList.size();

        // BFS-search
        while (!vertices.isEmpty()) {
            final int currentIndex = vertices.poll();
            final String currentString = wordList.get(currentIndex);
            final int currentDepth = dist[currentIndex] + 1;
            if (dist[currentIndex] < lastDepth) {
                for (int i = 0; i < wordList.size(); i++) {
                    if (dist[i] == 0 || dist[i] == currentDepth) {
                        if (differInOneLetter(currentString, wordList.get(i))) {
                            if (i == endIndex) {
                                lastDepth = currentDepth;
                            } else if (dist[i] == 0) {
                                vertices.add(i);
                                dist[i] = currentDepth;
                            }
                            chains.get(i).add(currentIndex);
                        }
                    }
                }
            }
        }

        return restoreChains(chains, endIndex, beginWord, wordList, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<String>> restoreChains(final List<List<Integer>> chains, final int index,
                                                    final String beginWord, final List<String> wordList,
                                                    List<List<String>> ladders, ArrayList<String> currentLadder) {

        if (index == -1) {
            ArrayList<String> updLadder = (ArrayList) currentLadder.clone();
            updLadder.add(0, beginWord);
            ladders.add(updLadder);
        } else {
            for (Integer newIndex:chains.get(index)) {
                ArrayList<String> updLadder = (ArrayList) currentLadder.clone();
                updLadder.add(0, wordList.get(index));
                ladders = restoreChains(chains, newIndex, beginWord, wordList, ladders, updLadder);
            }
        }

        return ladders;
    }

    public boolean differInOneLetter (final String first, final String second) {
        boolean differOnce = false;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (differOnce) {
                    return false;
                } else {
                    differOnce = true;
                }
            }
        }

        return differOnce;
    }
}