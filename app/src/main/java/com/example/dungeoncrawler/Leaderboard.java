package com.example.dungeoncrawler;

public class Leaderboard {
    private volatile static Leaderboard leaderboard;

    private static int score;
    private static Location location;
    private Leaderboard(int score) {
        this.score = score;
        this.location = new Location(0.0f, 0.0f);
    }
    public static Leaderboard getLeaderboard(int score) {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard(score);
                }
            }
        }
        return leaderboard;
    }
    public static int getScore() {
        return score;
    }
    public static void setScore(int score) {
        Leaderboard.score = score;
    }
    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Leaderboard.location.setxCord(newX);
        Leaderboard.location.setyCord(newY);
    }
}
