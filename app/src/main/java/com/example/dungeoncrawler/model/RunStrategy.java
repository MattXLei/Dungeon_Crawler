package com.example.dungeoncrawler.model;

public class RunStrategy implements MovementStrategy {
    public void moveUp() {
        Player.getLocation().setyCord(Player.getLocation().getyCord() - 50);
    }
    public void moveDown() {
        Player.getLocation().setyCord(Player.getLocation().getyCord() + 50);
    }
    public void moveLeft() {
        Player.getLocation().setxCord(Player.getLocation().getxCord() - 50);
    }
    public void moveRight() {
        Player.getLocation().setxCord(Player.getLocation().getxCord() + 50);
    }
}
