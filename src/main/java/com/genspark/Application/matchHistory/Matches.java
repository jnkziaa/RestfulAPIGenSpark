package com.genspark.Application.matchHistory;

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

    public void setMap(String map) {
        this.map = map;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
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