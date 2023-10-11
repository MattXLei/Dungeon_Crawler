package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Player;

public class SettingsTest {

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
    public void testDifficulty() {
        Player.setDifficulty(2);
        assertEquals(50, Player.getHealth());
        Player.setDifficulty(1);
        assertEquals(75, Player.getHealth());
        Player.setDifficulty(0);
        assertEquals(100, Player.getHealth());
    }
}
