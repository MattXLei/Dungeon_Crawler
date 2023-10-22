package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;

import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.view.GameActivity;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovementTest {
    @Test
    public void testWalk() {
        int x = 500;
        int y = 500;
        Player.setLocation(x,y);
        Player.setMovementStrategy(new WalkStrategy());
        Player.getMovementStrategy().moveUp();
        y-=25;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
        Player.getMovementStrategy().moveDown();
        y+=25;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
        Player.getMovementStrategy().moveLeft();
        x-=25;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
        Player.getMovementStrategy().moveRight();
        x+=25;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
    }
    @Test
    public void testRun() {
        int x = 500;
        int y = 500;
        Player.setLocation(x,y);
        Player.setMovementStrategy(new RunStrategy());
        Player.getMovementStrategy().moveUp();
        y-=50;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y, 0);
        Player.getMovementStrategy().moveDown();
        y+=50;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
        Player.getMovementStrategy().moveLeft();
        x-=50;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
        Player.getMovementStrategy().moveRight();
        x+=50;
        assertEquals(Player.getLocation().getxCord(),x,0);
        assertEquals(Player.getLocation().getyCord(),y,0);
    }
}
