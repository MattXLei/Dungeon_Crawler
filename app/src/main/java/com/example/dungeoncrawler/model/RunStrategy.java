package com.example.dungeoncrawler.model;

public class RunStrategy implements MovementStrategy {
    private int step = 50;
    private Player player = Player.getPlayer();
    public void moveUp() {
        player.getLocation().setyCord(player.getLocation().getyCord() - 50);
    }
    public void moveDown() {
        player.getLocation().setyCord(player.getLocation().getyCord() + 50);
    }
    public void moveLeft() {
        player.getLocation().setxCord(player.getLocation().getxCord() - 50);
    }
    public void moveRight() {
        player.getLocation().setxCord(player.getLocation().getxCord() + 50);
    }
    public int getStep() {
        return step;
    }
}
