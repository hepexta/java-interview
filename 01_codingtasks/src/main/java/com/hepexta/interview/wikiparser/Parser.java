package com.hepexta.interview.wikiparser;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Parser {

    public static void main(String[] args) {
        String root = "rootUrl";
        long time = new Date().getTime();
        PageRepository.init(root);
        System.out.println("init successful "+ getSeconds(time));
        long time2 = new Date().getTime();
        Set<Page> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            String pageUrl = stack.pop();
            Page page = parseHtml(pageUrl);
            if (!visited.contains(page)){
                visited.add(page);
                for (String link : page.getLinks()) {
                    stack.push(link);
                }
            }
        }
        System.out.println("All visited "+ getSeconds(time2));
        System.out.println(visited.size());
    }

    private static long getSeconds(long time) {
        return (new Date().getTime()-time)/1000;
    }

    private static Page parseHtml(String url){
        return PageRepository.getPage(url);
    }

}
