package com.example.dungeoncrawler.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Leaderboard {
    private static volatile Leaderboard leaderboard;

    private final int size = 5;

    private DateFormat date = new SimpleDateFormat("MMM dd yyyy, h:mm");

    private Attempt[] attempts = new Attempt[size];
    private Location location;

    private Player player;

    private static Attempt mostRecent = null;
    private Leaderboard() {
<<<<<<< HEAD
        attempts[0] = new Attempt(Player.getName(), Player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        this.location = new Location(0.0f, 0.0f);
=======
        player = Player.getPlayer();
        //   attempts[0] = new Attempt(player.getName(), player.getScore(),
        //   date.format(Calendar.getInstance().getTime()));
        location = new Location(0.0f, 0.0f);
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
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

<<<<<<< HEAD
    public static void addAttempt() {
        mostRecent = new Attempt(Player.getName(), Player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        for (int i = 0; i < SIZE; i++) {
            if (attempts[i] == null) {
                attempts[i] = new Attempt(Player.getName(), Player.getScore(),
=======
    public void addAttempt() {
        mostRecent = new Attempt(player.getName(), player.getScore(),
                date.format(Calendar.getInstance().getTime()));
        for (int i = 0; i < size; i++) {
            if (attempts[i] == null) {
                attempts[i] = new Attempt(player.getName(), player.getScore(),
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
                        date.format(Calendar.getInstance().getTime()));
                Arrays.sort(attempts, 0, i + 1);
                return;
            }
        }
<<<<<<< HEAD
        if (player.getScore() <= attempts[size - 1].getScore()) {
            return;
        } else {
            attempts[size - 1] = new Attempt(player.getName(), player.getScore(),
=======
<<<<<<< HEAD
        if (Player.getScore() <= attempts[SIZE - 1].getScore()) {
            return;
        } else {
            attempts[SIZE - 1] = new Attempt(Player.getName(), Player.getScore(),
=======
        if (player.getScore() <= attempts[SIZE - 1].getScore()) {
            return;
        } else {
            attempts[SIZE - 1] = new Attempt(player.getName(), player.getScore(),
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
>>>>>>> 34aa21853468e3f2ade9628567f80c1a70a0cd72
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

<<<<<<< HEAD
    public static Attempt getMostRecent() {
=======
    public Attempt getMostRecent() {
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
        return mostRecent;
    }

    public void empty() {
        for (int i = 0; i < size; i++) {
            attempts[i] =  null;
        }
    }
    public void setLocation(float newX, float newY) {
        this.location.setxCord(newX);
        this.location.setyCord(newY);
    }
}
