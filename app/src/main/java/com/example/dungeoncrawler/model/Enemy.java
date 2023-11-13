package com.example.dungeoncrawler.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Observable {
    protected int health;
    protected int xMove;
    protected int yMove;
    protected int defense;
    protected int damage;
    protected int damageMultiplier = 1;

    protected Location location;
    protected Location playerLocation;

    private List<Observer> wallList;

    public Enemy(int health, int xMove, int yMove, int defense, int damage,
                 Location location) {
        this.health = health;
        this.xMove = xMove;
        this.yMove = yMove;
        this.defense = defense;
        this.damage = damage;
        this.location = new Location(location.getxCord(), location.getyCord());
        wallList = new ArrayList<>();
    }

    public Enemy() {

    }

    public void update(Location location) {
        playerLocation = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setDamageMultiplier(int multiplier) {
        damageMultiplier = multiplier;
    }

    public void setCoords(int newX, int newY) {
        xMove = newX;
        yMove = newY;
    }

    public void movement() {
        location.setxCord(location.getxCord() + xMove);
        location.setyCord(location.getyCord() + yMove);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addObserver(Observer wall) {
        wallList.add(wall);
    }

    public void removeObserver(Observer wall) {
        wallList.remove(wall);
    }

    public void removeAllObservers() {
        wallList = new ArrayList<>();
    }

    public boolean validMove(int changeX, int changeY) {
        for (Observer currWall : wallList) {
            if (currWall.checkCollision(location, changeX, changeY)) {
                return false;
            }
        }
        return true;
    }

    public void notifyObservers() {
        for(Observer o: wallList) {
            o.update(location);
        }
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
    public int getxMove() {
        return xMove;
    }
    public int getyMove() {
        return yMove;
    }
}
