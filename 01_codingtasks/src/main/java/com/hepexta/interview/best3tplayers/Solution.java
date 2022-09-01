package com.hepexta.interview.best3tplayers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/*
* Get top 3 players per day with O(1) time complexity
* */
public class Solution {


    /********************** class vars  ****************************/

    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

    private final String May01st = "2022-05-01";
    private final String May02nd = "2022-05-02";
    private final String May03rd = "2022-05-03";
    private final String May04th = "2022-05-04";

    private final String David = "David";
    private final String Jeff = "Jeff";
    private final String Kim = "Kim";
    private final String Peter = "Peter";

    /********************** input data  ****************************/
    private List<Score> buildData() throws Exception{
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(May01st,David,456));
        scores.add(new Score(May01st,Jeff,512));
        scores.add(new Score(May01st,Jeff,605));
        scores.add(new Score(May01st,Kim,256));
        scores.add(new Score(May01st,Kim,331));
        scores.add(new Score(May01st,Kim,610));
        scores.add(new Score(May01st,Peter,100));

        scores.add(new Score(May02nd,David,560));

        scores.add(new Score(May03rd,David,222));

        scores.add(new Score(May04th,David,456));
        scores.add(new Score(May04th,David,676));
        scores.add(new Score(May04th,Jeff,192));
        scores.add(new Score(May04th,Jeff,653));
        scores.add(new Score(May04th,Kim,525));
        scores.add(new Score(May04th,Kim,599));

        return scores;

    }

    public void testBest3Scorers() throws Exception{

        ingestData(buildData());

        //2022-05-01
        final List<Score> bestMay01st = best3TopPlayersByDate(string2date(May01st));
        assert bestMay01st != null && bestMay01st.size()==3;
        assert isSameScore(bestMay01st.get(0), May01st, Kim, 1197);
        assert isSameScore(bestMay01st.get(1), May01st, Jeff, 1117);
        assert isSameScore(bestMay01st.get(2), May01st, David, 456);


        //2022-05-02
        final List<Score> bestMay02nd = best3TopPlayersByDate(string2date(May02nd));
        assert bestMay02nd != null && bestMay02nd.size()==1;
        assert isSameScore(bestMay02nd.get(0), May02nd, David, 560);

        //2022-05-03
        final List<Score> bestMay03rd = best3TopPlayersByDate(string2date(May03rd));
        assert bestMay03rd != null && bestMay03rd.size()==1;
        assert isSameScore(bestMay03rd.get(0), May03rd, David, 222);

        //2022-05-04
        final List<Score> bestMay04th = best3TopPlayersByDate(string2date(May04th));
        assert bestMay04th != null && bestMay04th.size()==3;
        assert isSameScore(bestMay04th.get(0), May04th, David, 1132);
        assert isSameScore(bestMay04th.get(1), May04th, Kim, 1124);
        assert isSameScore(bestMay04th.get(2), May04th, Jeff, 845);

    }


    /************************ model  *******************************/
    private class Score {
        Date date;
        String player;
        Integer ranking;
        Score( String _dateStr, String _player, Integer _score ) throws Exception {
            date = string2date(_dateStr);
            player= _player;
            ranking = _score;
        }

        @Override
        public String toString(){
            return date2String(this.date) + " - " + this.player + "-" + this.ranking;
        }


    }

    /**************** utility methods *******************************/
    private boolean isSameScore(Score source, String expectedDate, String expectedName, int expectedScore){
        return source != null && date2String(source.date).equals(expectedDate) && source.player.equals(expectedName) && source.ranking.equals(expectedScore);
    }
    private Date string2date(String dateString) throws ParseException{
        return ft.parse(dateString);
    }
    private String date2String(Date date){
        return ft.format(date);
    }




    /*********************** to be done BY THE CANDIDATE SOLUTION ******************************/

    private final Map<Date, List<Score>> scoreMap = new HashMap<>();

    private void ingestData(List<Score> scores){
        for (Score score: scores) {
            if (scoreMap.containsKey(score.date)) {
                List<Score> scoreList = scoreMap.get(score.date);
                scoreMap.put(score.date, updateSum(scoreList, score));
            }
            else {
                scoreMap.put(score.date, updateSum(new ArrayList<>(), score));
            }
        }
        // top 3
        for (Map.Entry<Date, List<Score>> dateListEntry : scoreMap.entrySet()) {
            List<Score> top3List = dateListEntry.getValue().stream()
                    .sorted((o1, o2) -> o2.ranking - o1.ranking)
                    .limit(3)
                    .collect(Collectors.toList());
            scoreMap.put(dateListEntry.getKey(), top3List);
        }
    }

    private List<Score> best3TopPlayersByDate(Date date) {
        return scoreMap.get(date);
    }

    private List<Score> updateSum(List<Score> scores, Score scoreToSum) {
        boolean contains = false;
        for (Score score: scores) {
            if (score.player.equals(scoreToSum.player)) {
                score.ranking = score.ranking + scoreToSum.ranking;
                contains = true;
            }
        }
        if (!contains) {
            scores.add(scoreToSum);
        }
        return scores;
    }


    /*********************** to be done BY THE CANDIDATE SOLUTION ******************************/




}
