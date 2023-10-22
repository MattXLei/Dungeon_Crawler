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
        player.getMovementStrategy().moveUp();
        y-=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.getMovementStrategy().moveDown();
        y+=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.getMovementStrategy().moveLeft();
        x-=25;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.getMovementStrategy().moveRight();
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
        player.getMovementStrategy().moveUp();
        y-=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y, 0);
        player.getMovementStrategy().moveDown();
        y+=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.getMovementStrategy().moveLeft();
        x-=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
        player.getMovementStrategy().moveRight();
        x+=50;
        assertEquals(player.getLocation().getxCord(),x,0);
        assertEquals(player.getLocation().getyCord(),y,0);
    }
}
