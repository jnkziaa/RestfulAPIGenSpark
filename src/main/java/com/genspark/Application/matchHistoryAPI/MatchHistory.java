package com.genspark.Application.matchHistoryAPI;

import java.util.List;

public class MatchHistory {
    private String id;
    private String userName;
    private int points;

    private String title;
    private List<Matches> matches;


    public MatchHistory(String id, String userName, int points, String title, List<Matches> matches) {
        this.id = id;
        this.userName = userName;
        this.points = points;
        this.title = title;
        this.matches = matches;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUserName() {
        return userName;
    }

    public int getPoints() {
        return points;
    }

    public String getTitle() {
        return title;
    }

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "MatchHistory{" +
                "id='" + id + '\'' +
                ", points=" + points +
                ", title='" + title + '\'' +
                ", matches=" + matches +
                '}';
    }
}
