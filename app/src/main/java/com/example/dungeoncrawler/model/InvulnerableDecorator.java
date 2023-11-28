package com.example.dungeoncrawler.model;

public class InvulnerableDecorator extends PowerupDecorator {
    public InvulnerableDecorator(Powerupable p) {
        powerup = p;
    }

    public boolean getInvulnerability() {
        return true;
    }
}
