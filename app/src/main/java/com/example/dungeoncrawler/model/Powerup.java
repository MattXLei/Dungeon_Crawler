package com.example.dungeoncrawler.model;

public class Powerup {
    private static Location location;

    private static final long POWERUPSCORE = 50;

    public Powerup(Location location) {
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Powerup.location.setxCord(newX);
        Powerup.location.setyCord(newY);
    }

    public static long getPowerupScore() {
        return POWERUPSCORE;
    }
}
