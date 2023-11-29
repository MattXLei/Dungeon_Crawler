package com.example.dungeoncrawler.model;

public abstract class PowerupDecorator implements Powerupable, Observer {
    protected Powerupable powerup;
    protected Location location;
    protected Location playerLocation;
    public int getSpeed() {
        return powerup.getSpeed();
    }
    public int getHealth() {
        return powerup.getHealth();
    }
    public boolean getInvulnerability() {
        return powerup.getInvulnerability();
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
