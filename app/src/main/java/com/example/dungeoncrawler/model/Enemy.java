package com.example.dungeoncrawler.model;

public abstract class Enemy {
    protected int health;
    protected int xMove;
    protected int yMove;
    protected int defense;
    protected int damage;
    protected Location location;
    protected Location playerLocation;

    public Enemy(int health, int xMove, int yMove, int defense, int damage, Location location) {
        this.health = health;
        this.xMove = xMove;
        this.yMove = yMove;
        this.defense = defense;
        this.damage = damage;
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
