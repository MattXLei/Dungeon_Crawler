package com.example.dungeoncrawler;

public class Player {

    private static Player player;

    private static int health;

    private static int speed;

    private static int direction;

    private static long score;

    private static String name;

    // location implementation different than others. Only created when new Player created.
    private static Location location;

    private Player(int health, int speed, int direction, long score, String name) {
        this.health = health;
        this.speed = speed;
        this.direction = direction;
        this.score = score;
        this.name = name;
        this.location = new Location(0.0f, 0.0f);
    }

    public static Player getPlayer(int health, int speed, int direction, long score, String name) {
        if (player == null) {
            player = new Player(health, speed, direction, score, name);
        }
        return player;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        if (name == null) {
            System.out.println("Input name cannot be null!");
        } else if (name.equals("")) {
            System.out.println("Input name cannot be empty!");
        } else if (name.trim().isEmpty()) {
            System.out.println("Input name cannot only contain whitespaces!");
        } else {
            Player.name = name;
        }
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Player.speed = speed;
    }

    public static int getDirection() {
        return direction;
    }

    public static void setDirection(int direction) {
        Player.direction = direction;
    }

    public static long getScore() {
        return score;
    }

    public static void setScore(long score) {
        Player.score = score;
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(float newX, float newY) {
        Player.location.setxCord(newX);
        Player.location.setyCord(newY);
    }
}
