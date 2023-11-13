package com.example.dungeoncrawler.model;

public class Spirit extends Enemy {
    Spirit() {
        health = 100;
        defense = 10;
        damage = 5;
        location = new Location(0, 0);
        int[] movementCycleX = {10, 10, 10, 10, -10, -10, -10, -10};
        int[] movementCycleY = {10, 10, 10, 10, -10, -10, -10, -10};
        tickCount = 0;
    }
}
