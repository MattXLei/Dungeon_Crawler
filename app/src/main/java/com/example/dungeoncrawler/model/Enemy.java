package com.example.dungeoncrawler.model;

public abstract class Enemy {
    protected int health;
    protected int speed;
    protected int defense;
    protected Location location;
    protected Location playerLocation;

    public Enemy(int health, int speed, int defense, Location location) {
        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.location = new Location(location.getxCord(), location.getyCord());
    }
    public Enemy() {

    }

    public void update(Location location) {
        playerLocation = location;
    }

    public Location getLocation() {
        return location;
    }

    public void movement() {

    }

}
