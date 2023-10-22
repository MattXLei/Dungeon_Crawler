package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;


import com.example.dungeoncrawler.model.Player;

import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovementTest {
    
    Player player = Player.getPlayer();
    @Test
    public void testWalk() {
        int x = 500;
        int y = 500;
        player.setLocation(x,y);
        player.setMovementStrategy(new WalkStrategy());
        player.moveUp();
        y-=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.moveDown();
        y+=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.moveLeft();
        x-=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.moveRight();
        x+=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
    }
    @Test
    public void testRun() {
        int x = 500;
        int y = 500;
        player.setLocation(x,y);
        player.setMovementStrategy(new RunStrategy());
        player.moveUp();
        y-=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y, 0);
        player.moveDown();
        y+=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.moveLeft();
        x-=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.moveRight();
        x+=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
    }
}
