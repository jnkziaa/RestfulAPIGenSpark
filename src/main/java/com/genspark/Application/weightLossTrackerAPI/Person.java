package com.genspark.Application.weightLossTrackerAPI;

import java.util.List;

public class Person {

    private int id;
    private String name;
    private String title;
    private int originalWeight;
    private int weightGoal;
    private List<Weeks> weeksList;

    public Person(int id, String name, String title, int originalWeight, int weightGoal, List<Weeks> weeksList) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.originalWeight = originalWeight;
        this.weightGoal = weightGoal;
        this.weeksList = weeksList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOriginalWeight() {
        return originalWeight;
    }

    public void setOriginalWeight(int originalWeight) {
        this.originalWeight = originalWeight;
    }

    public int getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(int weightGoal) {
        this.weightGoal = weightGoal;
    }

    public List<Weeks> getWeeksList() {
        return weeksList;
    }

    public void setWeeksList(List<Weeks> weeksList) {
        this.weeksList = weeksList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", originalWeight=" + originalWeight +
                ", weightGoal=" + weightGoal +
                ", weeksList=" + weeksList +
                '}';
    }
}
