package com.example.dungeoncrawler.model;

public class HealthDecorator extends PowerupDecorator {
    public HealthDecorator(Powerupable p) {
        powerup = p;
    }
    public int getHealth() {
        return powerup.getHealth() + 20;
    }
}
