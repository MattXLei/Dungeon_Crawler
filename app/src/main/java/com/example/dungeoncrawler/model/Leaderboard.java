package com.example.dungeoncrawler.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

public class Leaderboard {
    private volatile static Leaderboard leaderboard;

    private static DateFormat date = new SimpleDateFormat("MMM dd yyyy, h:mm");

    private static class Attempt implements Comparable<Attempt>{
        private String name;
        private long score;
        private String date;

        private Attempt(String name, long score, String date) {
            this.name = name;
            this.score = score;
            this.date = date;
        }
        @Override
        public int compareTo(Attempt attempt) {
            if (this.score > attempt.score) {
                return 1;
            }
            else if (this.score < attempt.score) {
                return -1;
            }
            else {
                return 0;
            }
        }

    }

    private static Attempt[] attempts = new Attempt[5];
    private static Location location;
    private Leaderboard() {
        attempts[0] = new Attempt(Player.getName(), Player.getScore(), date.format(Calendar.getInstance().getTime()));
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
        if (Player.getScore() <= attempts[4].score)
            return;
        else {
            attempts[4] = new Attempt(Player.getName(), Player.getScore(), date.format(Calendar.getInstance().getTime()));
            Arrays.sort(attempts);
        }
    }
    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Leaderboard.location.setxCord(newX);
        Leaderboard.location.setyCord(newY);
    }
}
