package com.example.dungeoncrawler.model;

public class Powerup implements Powerupable {
    private static Location location;
    private int speed;
    private int health;
    private static final long POWERUPSCORE = 50;

    public Powerup(Location location) {
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public static Location getLocation() {
        return location;
    }
    public static void setLocation(int newX, int newY) {
        Powerup.location.setxCord(newX);
        Powerup.location.setyCord(newY);
    }

    public static long getPowerupScore() {
        return POWERUPSCORE;
    }
    public int getSpeed() {
        return speed;
    }
    public int getHealth() {
        return health;
    }
    public boolean getInvulnerability() {
        return false;
    }
}
