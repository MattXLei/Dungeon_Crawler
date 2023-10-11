package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Player;

public class PlayerTest {

    Player player = Player.getPlayer();

    @Test
    public void testName() {
        Player.setName("helloWorld");
        assertEquals("helloWorld", Player.getName());
        Player.setName("     ");
        assertEquals("helloWorld", Player.getName());
        Player.setName("");
        assertEquals("helloWorld", Player.getName());
        Player.setName("  hi  ");
        assertEquals("hi", Player.getName());
        Player.setName(null);
        assertEquals("hi", Player.getName());
    }

    @Test
    public void testDifficulty1() {
        Player.setDifficulty(2);
        assertEquals(50, Player.getHealth());
    }
    @Test
    public void testDifficulty2() {
        Player.setDifficulty(1);
        assertEquals(75, Player.getHealth());
    }
    @Test
    public void testDifficulty3() {
        Player.setDifficulty(0);
        assertEquals(100, Player.getHealth());
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
    public void testTrashName() { // ensures Player naming is not illegal
        Player.setName("Bob");
        assertEquals("Bob", Player.getName());
        Player.setName(null);
        assertEquals("Bob", Player.getName());
        Player.setName(" ");
        assertEquals("Bob", Player.getName());
        Player.setName("         ");
        assertEquals("Bob", Player.getName());
        Player.setName("         Candace");
        assertEquals("Candace", Player.getName());
        Player.setName("Tracy         ");
        assertEquals("Tracy", Player.getName());
    }
}
