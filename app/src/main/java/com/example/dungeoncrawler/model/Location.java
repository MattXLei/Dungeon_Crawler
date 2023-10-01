package com.example.dungeoncrawler.model;

public class Location {
    private float xCord;
    private float yCord;

    public Location(float xCord, float yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public float getxCord() {
        return xCord;
    }

    public void setxCord(float xCord) {
        this.xCord = xCord;
    }

    public float getyCord() {
        return yCord;
    }

    public void setyCord(float yCord) {
        this.yCord = yCord;
    }
}
