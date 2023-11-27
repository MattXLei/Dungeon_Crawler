package com.example.dungeoncrawler.model;

public class DamageDecorator extends PowerupDecorator {
    public DamageDecorator(Powerupable p) {
        powerup = p;
    }
    public int getDamage() {
        return powerup.getDamage() + 40;
    }
}
