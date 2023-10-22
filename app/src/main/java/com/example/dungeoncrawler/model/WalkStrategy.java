package com.example.dungeoncrawler.model;

public class WalkStrategy implements MovementStrategy{
    private Player player = Player.getPlayer();
    public void moveUp() {
        player.getLocation().setyCord(player.getLocation().getyCord() - 25);
    }
    public void moveDown() {
        player.getLocation().setyCord(player.getLocation().getyCord() + 25);
    }
    public void moveLeft() {
        player.getLocation().setxCord(player.getLocation().getxCord() - 25);
    }
    public void moveRight() {
        player.getLocation().setxCord(player.getLocation().getxCord() + 25);
    }
}
