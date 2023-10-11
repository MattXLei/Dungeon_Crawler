package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Player;

public class PlayerTest {

    Player player = Player.getPlayer();

    @Test
    public void playerFieldsTest() {
        Player.setName("A");
        Player.setScore(100);
        Player.setDifficulty(1);
        Player.setCharacter(1000000);
        Player.setLocation(1f, 2f);
        Player.setDirection(1);
        Player.setHealth(100);
        Player.setSpeed(10);

        assertEquals("A", Player.getName());
        assertEquals(100, Player.getScore());
        assertEquals(1, Player.getDifficulty());
        assertEquals(1000000, Player.getCharacter());
        assertEquals(1f, Player.getLocation().getxCord(), 0f);
        assertEquals(2f, Player.getLocation().getyCord(), 0f);
        assertEquals(1, Player.getDirection());
        assertEquals(100, Player.getHealth());
        assertEquals(10, Player.getSpeed());
    }

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
    public void testIllegalName() { // ensures Player naming is not illegal
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
}
