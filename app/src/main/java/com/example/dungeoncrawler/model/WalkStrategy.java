package com.example.dungeoncrawler.model;

public class WalkStrategy implements MovementStrategy{
    public void moveUp() {
        Player.getLocation().setyCord(Player.getLocation().getyCord() - 25);
    }
    public void moveDown() {
        Player.getLocation().setyCord(Player.getLocation().getyCord() + 25);
    }
    public void moveLeft() {
        Player.getLocation().setxCord(Player.getLocation().getxCord() - 25);
    }
    public void moveRight() {
        Player.getLocation().setxCord(Player.getLocation().getxCord() + 25);
    }
}
