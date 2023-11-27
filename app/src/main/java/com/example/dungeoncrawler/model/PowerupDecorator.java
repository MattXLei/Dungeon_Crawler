package com.example.dungeoncrawler.model;

public abstract class PowerupDecorator {
    protected Powerup powerup;

    public int getSpeed() {
        return powerup.getSpeed();
    }
    public int getHealth() {
        return powerup.getHealth();
    }
    public int getDamage() {
        return powerup.getDamage();
    }
}
