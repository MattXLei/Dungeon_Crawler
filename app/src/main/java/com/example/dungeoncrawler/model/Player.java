package com.example.dungeoncrawler.model;
import java.util.*;

public class Player extends Entity implements Observable{

<<<<<<< HEAD
    private static volatile Player player = new Player();
=======
    private static volatile Player player;
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6

    private int health;

    private int speed;

    private int direction;

    private long score;

    private String name;

    private int character;

    // location implementation different than others. Only created when new Player created.
    //private Location location;

    private int difficulty;

    private Location location;

    private List<Observer> wallList;

    private Player(int health, int speed, int direction, long score, String name, int difficulty) {
        super(null);
        this.health = health;
        this.speed = speed;
        this.direction = direction;
        this.score = score;
        this.name = name;
        this.location = new Location(0.0f, 0.0f);
        this.difficulty = difficulty;
        wallList = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("Input name cannot be null!");
        } else if (name.equals("")) {
            System.out.println("Input name cannot be empty!");
        } else if (name.trim().isEmpty()) {
            System.out.println("Input name cannot only contain whitespaces!");
        } else {
            this.name = name.trim();
        }
    }

    public void setCharacter(int id) {
        character = id;
    }

    public int getCharacter() {
        return character;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        if (score >= 0) {
            this.score = score;
        }
    }

    public void increaseScore(long amount) {
        this.score += amount;
    }

    public void decreaseScore(long amount) {
        this.score = Math.max(this.score - amount, 0);
    }

    public int getDifficulty() {
        return difficulty;
    }

<<<<<<< HEAD
    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        Player.difficulty = difficulty;
        if (difficulty == 2) {
=======
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        if (difficulty == 3) {
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
            setHealth(50);
        } else if (difficulty == 2) {
            setHealth(75);
        } else {
            setHealth(100);
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(float newX, float newY) {
        location.setxCord(newX);
        location.setyCord(newY);
    }

    public void addObserver(Observer wall) {
        wallList.add(wall);
    }

    public void removeObserver(Observer wall) {
        wallList.remove(wall);
    }

    public boolean validMove(int changeX, int changeY) {
        for (Observer currWall : wallList) {
            if (currWall.checkCollision(location, changeX, changeY)) {
                return false;
            }
        }
        return true;
    }
}