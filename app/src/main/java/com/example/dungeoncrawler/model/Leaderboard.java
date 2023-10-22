package com.example.dungeoncrawler.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Leaderboard {
    private static volatile Leaderboard leaderboard;

    private final int SIZE = 5;

    private DateFormat date = new SimpleDateFormat("MMM dd yyyy, h:mm");

    private Attempt[] attempts = new Attempt[SIZE];
    private Location location;

    private Player player;

    private static Attempt mostRecent = null;
    private Leaderboard() {
        player = Player.getPlayer();
        attempts[0] = new Attempt(player.getName(), player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        location = new Location(0.0f, 0.0f);
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

    public void addAttempt() {
        mostRecent = new Attempt(player.getName(), player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        for (int i = 0; i < SIZE; i++) {
            if (attempts[i] == null) {
                attempts[i] = new Attempt(player.getName(), player.getScore(),
                        date.format(Calendar.getInstance().getTime()));
                Arrays.sort(attempts, 0, i + 1);
                return;
            }
        }
        if (player.getScore() <= attempts[SIZE - 1].getScore()) {
            return;
        } else {
            attempts[SIZE - 1] = new Attempt(player.getName(), player.getScore(),
                    date.format(Calendar.getInstance().getTime()));
            Arrays.sort(attempts);
        }
    }
    public Location getLocation() {
        return location;
    }
    public Attempt[] getAttempts() {
        return attempts;
    }

    public Attempt getMostRecent() {
        return mostRecent;
    }

    public void empty() {
        for (int i = 0; i < SIZE; i++) {
            attempts[i] =  null;
        }
    }
    public void setLocation(float newX, float newY) {
        this.location.setxCord(newX);
        this.location.setyCord(newY);
    }
}
