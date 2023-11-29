package com.example.dungeoncrawler.model;

public class Powerup implements Powerupable, Observer {
    private Location location;
    private Location playerLocation;
    private int speed;
    private int health;
    private static final long POWERUPSCORE = 50;

    public Powerup(Location location) {
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(int newX, int newY) {
        location.setxCord(newX);
        location.setyCord(newY);
    }

    public long getPowerupScore() {
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

    @Override
    public boolean checkCollision(Location entityLocation, int changeX, int changeY) {
        int newX = entityLocation.getxCord() + changeX;
        int newY = entityLocation.getyCord() + changeY;
        if (Math.abs(newX - location.getxCord()) <= 50
                && Math.abs(newY - location.getyCord()) <= 50) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Location location) {
        playerLocation = location;
    }
}
