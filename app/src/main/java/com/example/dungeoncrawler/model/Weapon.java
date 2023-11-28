package com.example.dungeoncrawler.model;

public abstract class Weapon {

    public Weapon() {
    }

    public void attack(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - Player.getPlayer().getDamage());
    }
}
