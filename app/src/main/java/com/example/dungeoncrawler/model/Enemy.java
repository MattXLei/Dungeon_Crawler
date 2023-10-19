package com.example.dungeoncrawler.model;

public class Enemy {
    private static int health;
    private static int speed;
    private static int direction;
    private static Location location;

    public Enemy(int health, int speed, int direction, Location location) {
        this.health = health;
        this.speed = speed;
        this.direction = direction;
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public static int getHealth() {
        return health;
    }
    public static void setHealth(int health) {
        Enemy.health = health;
    }
    public static int getSpeed() {
        return speed;
    }
    public static void setSpeed(int speed) {
        Enemy.speed = speed;
    }
    public static int getDirection() {
        return direction;
    }
    public static void setDirection(int direction) {
        Enemy.direction = direction;
    }
    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Enemy.location.setxCord(newX);
        Enemy.location.setyCord(newY);
    }
}
