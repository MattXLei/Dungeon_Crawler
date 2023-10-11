package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.Coin;
import com.example.dungeoncrawler.model.Chest;
import com.example.dungeoncrawler.model.Powerup;
import com.example.dungeoncrawler.model.Location;

public class ScoreTest {

    Player player = Player.getPlayer();

    @Test
    public void testIncreaseDecreaseScore() {
        Player.setScore(0);
        Player.increaseScore(10);
        assertEquals(10, Player.getScore());
        Player.increaseScore(100);
        assertEquals(110, Player.getScore());
        Player.decreaseScore(100);
        assertEquals(10, Player.getScore());
    }

    @Test
    public void testScoreSubzero() { // tests that score cannot dip below 0
        Player.setScore(0);
        assertEquals(0, Player.getScore());
        Player.setScore(-1);
        assertEquals(0, Player.getScore());
        Player.decreaseScore(10);
        assertEquals(0, Player.getScore());
        Player.increaseScore(20);
        assertEquals(20, Player.getScore());
        Player.decreaseScore(30);
        assertEquals(0, Player.getScore());
    }

    @Test
    public void testModelScore() {
        Player.setScore(0);

        //location is dummy value in this test
        Location location = new Location(0f, 0f);
        Coin coin = new Coin(location);
        Player.increaseScore(coin.getCoinScore());
        assertEquals(10, Player.getScore());

        Player.setScore(0);
        Powerup powerup = new Powerup(location);
        Player.increaseScore(powerup.getPowerupScore());
        assertEquals(50, Player.getScore());

        Player.setScore(0);
        Chest chest = new Chest(location);
        Player.increaseScore(chest.getChestScore());
        assertTrue(Player.getScore() >= 50);
        assertTrue(Player.getScore() <= 100);
    }

}
