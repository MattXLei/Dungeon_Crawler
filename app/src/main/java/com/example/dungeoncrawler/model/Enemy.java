package com.example.dungeoncrawler.model;

public abstract class Enemy implements Observer{
    private int health;
    private int speed;
    private Location location;
    private Location playerLocation;

    public Enemy(int health, int speed, Location location) {
        this.health = health;
        this.speed = speed;
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public void update(Location location) {
        playerLocation = location;
    }

    public void movement() {

    }

}
