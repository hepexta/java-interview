package com.hepexta.interview.strings;

import java.util.stream.Stream;

public class MinStringCoEff {
    /*
     * Complete the 'minStringCoeff' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER p
     */

    public static int minStringCoeff(String s, int p) {
        // Write your code here
        int result = 0;
        if (s != null && !s.isEmpty()) {
            Stream.of(s);
            result += sumCoef(s, "0");
            result += sumCoef(s, "1");
        }

        return result;
    }

    private synchronized static int sumCoef(String s, String seek) {
        int currSum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i)+"").equals(seek)) {
                while (i+1<s.length() && !(s.charAt(i)+"").equals(seek)){
                    currSum ++;
                    i++;
                }
            }
        }
        return currSum;
    }

    /*private void getChildPages(List<String> links){
        for (String link : links) {
            if (!wikiMap.containsKey(link)) {
                WikiPage wikiPage = Utils.scrap(Utils.downloadHtmlBody(link));
                wikiMap.put(link, wikiPage);
                getChildPages(wikiPage.links);
            }
        }
    }*/
}
