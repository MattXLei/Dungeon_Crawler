package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Leaderboard;
import com.example.dungeoncrawler.model.Player;

public class LeaderboardsTest {

    Player player = Player.getPlayer();
    Leaderboard leaderboard = Leaderboard.getLeaderboard();
    @Test
    public void addAttempt() {
        Leaderboard.addAttempt();
        assertEquals(Leaderboard.getAttempts()[0].getScore(),Player.getScore());

    }
}
