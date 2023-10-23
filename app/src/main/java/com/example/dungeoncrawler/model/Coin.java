package com.example.dungeoncrawler.model;

public class Coin {
    private static Location location;

    private static final long COINSCORE = 10;

    public Coin(Location location) {
        this.location = new Location(0.0f, 0.0f);
    }

    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Coin.location.setxCord(newX);
        Coin.location.setyCord(newY);
    }
}
