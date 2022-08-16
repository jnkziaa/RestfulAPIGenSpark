package com.genspark.Application.matchHistory;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class MatchHistoryService {

    private static List<MatchHistory> matchHistoryArrayList= new ArrayList<>();
    private static List<Matches> matchesList1 = new ArrayList<>();
    private static List<Matches> matchesList2 = new ArrayList<>();


    /**
     *
     * Static/fixed input for the default APIs
     *
     **/
    static {
        Matches match0 = new Matches("Match 1", "Bind", Arrays.asList("Aceu", "zeus", "eggoe", "Kimchi", "trippy"), 19, "Win", 19);
        Matches match1 = new Matches("Match 2", "Ascent", Arrays.asList("FrostStrix", "blackfires505", "AyDitto", "Kimchi", "darkwest03"), 23, "Lose", -17);
        Matches match2 = new Matches("Match 3", "Haven", Arrays.asList("lizard", "brrr15", "kikyo", "Kimchi", "hotdog"), 17, "Draw", 0);
        Matches match3 = new Matches("Match 4", "Icebox", Arrays.asList("hummy", "resue", "acid", "Kimchi", "northwest"), 15, "Win", 21);
        Matches match4 = new Matches("Match 5", "Pearl", Arrays.asList("sera", "ares", "lumia", "Kimchi", "huane"), 32, "Win", 25);
        matchesList1.add(match0);
        matchesList1.add(match1);
        matchesList1.add(match2);
        matchesList1.add(match3);
        matchesList1.add(match4);
        int totalPoints = matchesList1.stream().map(a->a.getPointsGained()).reduce(0, Integer::sum);
        MatchHistory matchHistory1 = new MatchHistory("Player 1","Kimchi", totalPoints, "Sentinel", matchesList1);
        matchHistoryArrayList.add(matchHistory1);
        Matches match5 = new Matches("Match 1", "Pearl", Arrays.asList("Doggo", "seua", "retua", "Ninjin", "tropau"), 19, "Lose", -18);
        Matches match6 = new Matches("Match 2", "Bind", Arrays.asList("Strixie", "Postua", "ayHello", "Ninjin", "westWeurd"), 23, "Win", 27);
        Matches match7 = new Matches("Match 3", "Split", Arrays.asList("numaer1", "polars2", "kushi", "Ninjin", "water15"), 17, "Lose", -25);
        Matches match8 = new Matches("Match 4", "Breeze", Arrays.asList("nuers", "hytsta", "dica", "Ninjin", "westLost"), 15, "Win", 21);
        Matches match9 = new Matches("Match 5", "Fracture", Arrays.asList("lostaw12", "reasff", "mioasf", "yuanes", "Ninjin"), 32, "Win", 25);
        matchesList2.add(match5);
        matchesList2.add(match6);
        matchesList2.add(match7);
        matchesList2.add(match8);
        matchesList2.add(match9);
        totalPoints = matchesList2.stream().map(a->a.getPointsGained()).reduce(0, Integer::sum);
        MatchHistory matchHistory2 = new MatchHistory("Player 2","Ninjin", totalPoints, "Initiator", matchesList2);
        matchHistoryArrayList.add(matchHistory2);
    }

    /**
     * Basically grabs every single information in the static API
     */
    public List<MatchHistory> retrieveAllMatches() {
        return matchHistoryArrayList;
    }

    /**
     * retrieves matchHistory through the ID taken from the URL
     * @param matchHistoryId
     * @return
     */
    public static MatchHistory retrieveMatchHistoryById(String matchHistoryId) {
        Predicate<? super MatchHistory> predicate = matchHistory -> matchHistory.getId().equalsIgnoreCase(matchHistoryId);
        Optional<MatchHistory> matchHistoryOptional= matchHistoryArrayList.stream().filter(predicate).findFirst();
        if(matchHistoryOptional.isEmpty()){
            return null;
        }

        return matchHistoryOptional.get();
    }

    /**
     * Lists the matches from the parameter matchHistoryId
     * @param matchHistoryId
     * @return
     */
    public List<Matches> retrieveAllMatchesInHistory(String matchHistoryId) {
        MatchHistory matchHistory = retrieveMatchHistoryById(matchHistoryId);
        if(matchHistory == null){
            return null;
        }
        return matchHistory.getMatches();
    }

    /**
     * deepest part of the API, specify which match to find and analyze
     * @param matchHistoryId
     * @param matchesId
     * @return the specific match
     */
    public static Matches retrieveSpecificMatches(String matchHistoryId, String matchesId) {
        MatchHistory matchHistory = retrieveMatchHistoryById(matchHistoryId);
        if(matchHistory == null){
            return null;
        }
        Predicate<? super Matches> predicate = matchesList -> matchesList.getId().equalsIgnoreCase(matchesId);
        Optional<Matches> optionalMatches = matchHistory.getMatches().stream().filter(predicate).findFirst();

        if(optionalMatches.isEmpty()){
            return null;
        }

        return optionalMatches.get();
    }
}
