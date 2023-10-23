package com.example.dungeoncrawler.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Leaderboard {
    private static volatile Leaderboard leaderboard;

    private static final int SIZE = 5;

    private static DateFormat date = new SimpleDateFormat("MMM dd yyyy, h:mm");

    private static Attempt[] attempts = new Attempt[SIZE];
    private static Location location;

    private static Attempt mostRecent = null;
    private Leaderboard() {
        attempts[0] = new Attempt(Player.getName(), Player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        this.location = new Location(0.0f, 0.0f);
    }
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }

    public static void addAttempt() {
        mostRecent = new Attempt(Player.getName(), Player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        for (int i = 0; i < SIZE; i++) {
            if (attempts[i] == null) {
                attempts[i] = new Attempt(Player.getName(), Player.getScore(),
                        date.format(Calendar.getInstance().getTime()));
                Arrays.sort(attempts, 0, i + 1);
                return;
            }
        }
        if (Player.getScore() <= attempts[SIZE - 1].getScore()) {
            return;
        } else {
            attempts[SIZE - 1] = new Attempt(Player.getName(), Player.getScore(),
                    date.format(Calendar.getInstance().getTime()));
            Arrays.sort(attempts);
        }
    }
    public static Location getLocation() {
        return location;
    }
    public static Attempt[] getAttempts() {
        return attempts;
    }

    public static Attempt getMostRecent() {
        return mostRecent;
    }

    public static void empty() {
        for (int i = 0; i < SIZE; i++) {
            attempts[i] =  null;
        }
    }
    public static void setLocation(float newX, float newY) {
        Leaderboard.location.setxCord(newX);
        Leaderboard.location.setyCord(newY);
    }
}
