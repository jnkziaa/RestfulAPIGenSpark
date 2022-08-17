package com.genspark.Application.weightLossTrackerAPI;

public class Weeks {
    private int id;
    private int averageCaloriesBurnt;
    private int averageSleep;
    private int averageCaloriesTaken;
    private int intensityMinutes;
    private int averageStepsAday;
    private int averageRunSpeed;

    public Weeks(int id, int averageCaloriesBurnt, int averageSleep, int averageCaloriesTaken, int intensityMinutes, int averageStepsAday, int averageRunSpeed) {
        this.id = id;
        this.averageCaloriesBurnt = averageCaloriesBurnt;
        this.averageSleep = averageSleep;
        this.averageCaloriesTaken = averageCaloriesTaken;
        this.intensityMinutes = intensityMinutes;
        this.averageStepsAday = averageStepsAday;
        this.averageRunSpeed = averageRunSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAverageCaloriesBurnt() {
        return averageCaloriesBurnt;
    }

    public void setAverageCaloriesBurnt(int averageCaloriesBurnt) {
        this.averageCaloriesBurnt = averageCaloriesBurnt;
    }

    public int getAverageSleep() {
        return averageSleep;
    }

    public void setAverageSleep(int averageSleep) {
        this.averageSleep = averageSleep;
    }

    public int getAverageCaloriesTaken() {
        return averageCaloriesTaken;
    }

    public void setAverageCaloriesTaken(int averageCaloriesTaken) {
        this.averageCaloriesTaken = averageCaloriesTaken;
    }

    public int getIntensityMinutes() {
        return intensityMinutes;
    }

    public void setIntensityMinutes(int intensityMinutes) {
        this.intensityMinutes = intensityMinutes;
    }

    public int getAverageStepsAday() {
        return averageStepsAday;
    }

    public void setAverageStepsAday(int averageStepsAday) {
        this.averageStepsAday = averageStepsAday;
    }

    public int getAverageRunSpeed() {
        return averageRunSpeed;
    }

    public void setAverageRunSpeed(int averageRunSpeed) {
        this.averageRunSpeed = averageRunSpeed;
    }

    @Override
    public String toString() {
        return "Weeks{" +
                "id=" + id +
                ", averageCaloriesBurnt=" + averageCaloriesBurnt +
                ", averageSleep=" + averageSleep +
                ", averageCaloriesTaken=" + averageCaloriesTaken +
                ", intensityMinutes=" + intensityMinutes +
                ", averageStepsAday=" + averageStepsAday +
                ", averageRunSpeed=" + averageRunSpeed +
                '}';
    }
}
