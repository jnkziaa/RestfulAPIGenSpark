package matchHistory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MatchHistoryService {

    private static List<MatchHistory> matchHistoryArrayList= new ArrayList<>();
    private static List<Matches> matchesList = new ArrayList<>();

    static {
        Matches match1 = new Matches("Match 1", "Bind", Arrays.asList("Aceu", "zeus", "eggoe", "Kimchi", "trippy"), 19, "Win", 19);
        Matches match2 = new Matches("Match 2", "Ascent", Arrays.asList("FrostStrix", "blackfires505", "AyDitto", "Kimchi", "darkwest03"), 23, "Lose", -17);
        Matches match3 = new Matches("Match 3", "Haven", Arrays.asList("lizard", "brrr15", "kikyo", "Kimchi", "hotdog"), 17, "Draw", 0);
        Matches match4 = new Matches("Match 4", "Icebox", Arrays.asList("hummy", "resue", "acid", "Kimchi", "northwest"), 15, "Win", 21);
        Matches match5 = new Matches("Match 5", "Pearl", Arrays.asList("sera", "ares", "lumia", "Kimchi", "huane"), 32, "Win", 25);
        matchesList.add(match1);
        matchesList.add(match2);
        matchesList.add(match3);
        matchesList.add(match4);
        matchesList.add(match5);
        int totalPoints = matchesList.stream().map(a->a.getPointsGained()).reduce(0, Integer::sum);
        MatchHistory matchHistory1 = new MatchHistory("Match 1", matchesList, totalPoints, "Sentinel");

        matchHistoryArrayList.add(matchHistory1);
    }


    public List<MatchHistory> retrieveAllMatches() {
        return matchHistoryArrayList;
    }
}
