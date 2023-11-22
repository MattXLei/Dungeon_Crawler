package com.example.dungeoncrawler.model;

public class SpeedDecorator extends PowerupDecorator  {
    protected Powerup powerup;
    public SpeedDecorator(Powerup p) {
        powerup = p;
    }
    public int getSpeed() {
        return powerup.getSpeed() + 10;
    }
}
