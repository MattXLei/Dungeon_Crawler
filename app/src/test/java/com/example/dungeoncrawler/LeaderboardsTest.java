package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Leaderboard;
import com.example.dungeoncrawler.model.Player;

public class LeaderboardsTest {

    Player player = Player.getPlayer();
    Leaderboard leaderboard = Leaderboard.getLeaderboard();
    // Tests whether or not the correct score of the player shows up  on the leaderboard
    @Test
    public void addAttempt() {
        Leaderboard.empty();
        Player.setScore(100);
        Leaderboard.addAttempt();
        assertEquals(Leaderboard.getAttempts()[0].getScore(), Player.getScore());
    }
    // Test whether attempts automatically sorts
    @Test
    public void SortedAttempts() {
        Leaderboard.empty();
        Player.setScore(20);
        Leaderboard.addAttempt();
        Player.setScore(5);
        Leaderboard.addAttempt();
        Player.setScore(30);
        Leaderboard.addAttempt();
        Player.setScore(50);
        Leaderboard.addAttempt();
        Player.setScore(40);
        Leaderboard.addAttempt();
        Player.setScore(10);
        Leaderboard.addAttempt();

        assertEquals(Leaderboard.getAttempts()[0].getScore(), 50);
        assertEquals(Leaderboard.getAttempts()[1].getScore(), 40);
        assertEquals(Leaderboard.getAttempts()[2].getScore(), 30);
        assertEquals(Leaderboard.getAttempts()[3].getScore(), 20);
        assertEquals(Leaderboard.getAttempts()[4].getScore(), 10);

    }
}
