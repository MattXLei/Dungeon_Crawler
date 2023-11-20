package com.example.dungeoncrawler.model;

public class HealthDecorator extends PowerupDecorator {
    protected Powerup powerup;
    public HealthDecorator(Powerup p) {
        powerup = p;
    }
}
