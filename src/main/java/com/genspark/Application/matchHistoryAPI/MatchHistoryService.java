package com.genspark.Application.matchHistoryAPI;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class MatchHistoryService {

    private static List<MatchHistory> matchHistoryArrayList = new ArrayList<>();
    private static List<Matches> matchesList;
    private static List<Matches> matchesList2;


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
        matchesList = new ArrayList<>(Arrays.asList(match0, match1, match2, match3, match4));
        int totalPoints = matchesList.stream().map(Matches::getPointsGained).reduce(0, Integer::sum);
        MatchHistory matchHistory1 = new MatchHistory("Player 1","Kimchi", totalPoints, "Sentinel", matchesList);
        matchHistoryArrayList.add(matchHistory1);

        Matches match5 = new Matches("Match 1", "Pearl", Arrays.asList("Doggo", "seua", "retua", "Ninjin", "tropau"), 19, "Lose", -18);
        Matches match6 = new Matches("Match 2", "Bind", Arrays.asList("Strixie", "Postua", "ayHello", "Ninjin", "westWeurd"), 23, "Win", 27);
        Matches match7 = new Matches("Match 3", "Split", Arrays.asList("numaer1", "polars2", "kushi", "Ninjin", "water15"), 17, "Lose", -25);
        Matches match8 = new Matches("Match 4", "Breeze", Arrays.asList("nuers", "hytsta", "dica", "Ninjin", "westLost"), 15, "Win", 21);
        Matches match9 = new Matches("Match 5", "Fracture", Arrays.asList("lostaw12", "reasff", "mioasf", "yuanes", "Ninjin"), 32, "Win", 25);
        matchesList2 = new ArrayList<>(Arrays.asList(match5, match6, match7, match8, match9));
        totalPoints = matchesList2.stream().map(Matches::getPointsGained).reduce(0, Integer::sum);
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
    public MatchHistory retrieveMatchHistoryById(String matchHistoryId) {
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
    public Matches retrieveSpecificMatch(String matchHistoryId, String matchesId) {
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

    /**
     * modifies points each time method is called.
     * @param matchHistoryId
     * @param matches
     * @return string version of the current number of matches in the API
     */
    public String addNewMatches(String matchHistoryId, Matches matches) {
        List<Matches> newMatchList = retrieveAllMatchesInHistory(matchHistoryId);
        int idTracker = Integer.parseInt(newMatchList.get(newMatchList.size()-1).getId().substring(6,7)) + 1;
        String actualMatchId = "Match " + idTracker;
        matches.setId(actualMatchId);
        newMatchList.add(matches);

        int newPoints = newMatchList.stream().map(Matches::getPointsGained).reduce(0, Integer::sum); //sum of the current total points of all the matches

        MatchHistory matchHistory = retrieveMatchHistoryById(matchHistoryId);
        if(matchHistory == null){
            return null;
        }
        matchHistory.setPoints(newPoints); //the points api is dynamic therefore each add, points are modified.
        return actualMatchId;
    }


    /**
     *
     * @param matchHistoryId
     * @param matchesId
     * @return
     */
    public String deleteSpecificMatch(String matchHistoryId, String matchesId) {
        List<Matches> matchesListInMethod = retrieveAllMatchesInHistory(matchHistoryId);
        if(matchesListInMethod == null){
            return null;
        }
        Predicate<Matches> predicate = match -> match.getId().equalsIgnoreCase(matchesId);
        boolean removedMatch = matchesListInMethod.removeIf(predicate);
        if(!removedMatch){

            return null;
        }

        return matchesId;

    }

    /**
     * updates or modifies a specific match
     * @param matchHistoryId
     * @param matchesId
     * @param matches
     */
    public void modifySpecificMatch(String matchHistoryId, String matchesId, Matches matches) {
        List<Matches> matchesListInMethod = retrieveAllMatchesInHistory(matchHistoryId);
        System.out.println(matchesListInMethod);
        Predicate<Matches> predicate = match -> match.getId().equalsIgnoreCase(matchesId);
        matchesListInMethod.removeIf(predicate);
        matchesListInMethod.add(matches);
    }
}
