package com.example.dungeoncrawler.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Observer {
    protected int health;
    protected int defense;
    protected int damage;

    protected int[] movementCycleX;
    protected int[] movementCycleY;

    protected int tickCount;
    protected int damageMultiplier = 1;

    protected Location location;
    protected Location playerLocation;

    public Enemy(int health, int defense, int damage, Location location) {
        this.health = health;
        this.defense = defense;
        this.damage = damage;
        this.location = new Location(location.getxCord(), location.getyCord());
        tickCount = 0;
    }

    public Enemy() {

    }

    public Location getLocation() {
        return location;
    }

    public void setDamageMultiplier(int multiplier) {
        damageMultiplier = multiplier;
    }

    public void setCoords(int newX, int newY) {
        location.setxCord(newX);
        location.setyCord(newY);
    }

    public void movement() {
        location.setxCord(location.getxCord() + (tickCount % movementCycleX.length));
        location.setyCord(location.getyCord() + (tickCount % movementCycleY.length));
        tickCount++;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public int getDamage() {
        return damage;
    }

    public boolean checkCollision(Location entityLocation, int changeX, int changeY) {
        int newX = entityLocation.getxCord() + changeX;
        int newY = entityLocation.getyCord() + changeY;
        if (Math.abs(newX - location.getxCord()) <= 10 && Math.abs(newY - location.getyCord()) <= 10) {
            return true;
        }
        return false;
    }

    public void update(Location location) {
        playerLocation = location;
    }
}
