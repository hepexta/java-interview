package com.hepexta.interview.wikiparser;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PageRepository {

    private static final int anInt = 49_000_00;
    private static HashMap<String, Page> pages = new HashMap<>();

    public static void init(String root) {
        pages.put(root, generate(root, 0));
        for (int i = 0; i < anInt; i++) {
            Page generate = generate(root, i);
            pages.put(generate.getPageUrl(), generate);
        }
    }

    private static Page generate(String root, int i) {
        return Page.builder()
                .pageUrl(root+i)
                .author(root+i)
                .content(root+i)
                .links(generateLinks(root, i))
                .build();
    }

    private static List<String> generateLinks(String root, int i) {
        return IntStream.range(1, 2).mapToObj(x -> root + (int)(Math.random()*anInt)).collect(Collectors.toList());
    }

    public static Page getPage(String url) {
        return pages.get(url);
    }
}
