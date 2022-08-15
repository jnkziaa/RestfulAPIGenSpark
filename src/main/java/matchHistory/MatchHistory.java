package matchHistory;

import java.util.List;

public class MatchHistory {
    private String id;
    private List<Matches> matches;
    private int points;

    private String title;

    public MatchHistory(String id, List<Matches> matches, int points, String title) {
        this.id = id;
        this.matches = matches;
        this.points = points;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MatchHistory{" +
                "id='" + id + '\'' +
                ", matches=" + matches +
                ", points='" + points + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
