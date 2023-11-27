package com.example.dungeoncrawler.model;

public class DamageDecorator extends PowerupDecorator {
    protected Powerup powerup;
    public DamageDecorator(Powerup p) {
        powerup = p;
    }
    public int getDamage() {
        return powerup.getDamage() + 40;
    }
}
