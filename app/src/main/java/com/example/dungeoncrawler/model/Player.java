package com.example.dungeoncrawler.model;

public class Player {

    private volatile static Player player = new Player();

    private static int health;

    private static int speed;

    private static int direction;

    private static long score;

    private static String name;

    private static int character;

    // location implementation different than others. Only created when new Player created.
    private static Location location;

    private static int difficulty;

    private Player(int health, int speed, int direction, long score, String name, int difficulty) {
        this.health = health;
        this.speed = speed;
        this.direction = direction;
        this.score = score;
        this.name = name;
        this.location = new Location(0.0f, 0.0f);
        this.difficulty = difficulty;
    }

    private Player() {
        this(100, 10,  10, 50, "", 0);
    }


    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }
            }
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
            Player.name = name.trim();
        }
    }

    public static void setCharacter(int id) {
        character = id;
    }

    public static int getCharacter() {
        return character;
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

    public static void increaseScore(long amount) {
        Player.score += amount;
    }

    public static void decreaseScore(long amount) {
        Player.score = Math.max(Player.score - amount, 0);
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(float newX, float newY) {
        Player.location.setxCord(newX);
        Player.location.setyCord(newY);
    }

    public static int getDifficulty() { return difficulty; }

    public static void setDifficulty(int difficulty) {
        Player.difficulty = difficulty;
        if (difficulty == 3) {
            setHealth(50);
        } else if (difficulty == 2) {
            setHealth(75);
        } else {
            setHealth(100);
        }
    }
}