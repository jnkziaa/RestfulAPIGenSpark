package com.genspark.Application.matchHistoryAPI;

import java.util.List;

public class Matches {

    private String id;
    private String map;
    private List<String> teamMembers;
    private int roundsPlayed;
    private String results;

    private int pointsGained;

    public int getPointsGained() {
        return pointsGained;
    }

    public void setPointsGained(int pointsGained) {
        this.pointsGained = pointsGained;
    }

    public Matches(String id, String map, List<String> teamMembers, int roundsPlayed, String results, int pointsGained) {
        this.id = id;
        this.map = map;
        this.teamMembers = teamMembers;
        this.roundsPlayed = roundsPlayed;
        this.results = results;
        this.pointsGained = pointsGained;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMap() {
        return map;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public String getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id='" + id + '\'' +
                ", map='" + map + '\'' +
                ", teamMembers=" + teamMembers +
                ", roundsPlayed=" + roundsPlayed +
                ", results='" + results + '\'' +
                ", pointsGained=" + pointsGained +
                '}';
    }
}