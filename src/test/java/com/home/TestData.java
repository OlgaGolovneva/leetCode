package com.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static final String DEFAULT_BEGIN_WORD = "hit";

    public static final String DEFAULT_END_WORD = "cog";

    public static final String CLOSEST_END_WORD = "hot";

    public static final String DIAMOND_BEGIN_WORD = "red";

    public static final String DIAMOND_END_WORD = "tax";

    public static final List<String> FULL_WORD_LIST =
            Arrays.asList("hot","dot","dog","lot","log","cog");

    public static final List<String> MISSING_WORD_LIST =
            Arrays.asList("hot","dot","dog","lot","log");

    public static final List<String> DIAMOND_WORD_LIST =
            Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");

    public static final List<List<String>> FULL_WORD_LIST_RESULT = Arrays.asList(
            Arrays.asList("hit","hot","dot","dog","cog"),
            Arrays.asList("hit","hot","lot","log","cog")
    );

    public static final List<List<String>> MISSING_WORD_LIST_RESULT = new ArrayList<>();

    public static final List<List<String>> SHORTEST_LIST_RESULT = Arrays.asList(
            Arrays.asList("hit","hot")
    );

    public static final List<List<String>> DIAMOND_WORD_LIST_RESULT = Arrays.asList(
            Arrays.asList("red","ted","tex","tax"),
            Arrays.asList("red","rex","tex","tax"),
            Arrays.asList("red","ted","tad","tax")
    );
}
