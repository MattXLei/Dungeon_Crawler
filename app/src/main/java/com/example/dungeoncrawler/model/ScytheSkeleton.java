package com.example.dungeoncrawler.model;

public class ScytheSkeleton extends Enemy {
    ScytheSkeleton() {
        health = 120;
        defense = 10;
        damage = 25;
        location = new Location(0, 0);
        int[] movementCycleY = {-5, -5, -5, -5, -5, -5, -5, 5, 5, 5, 5, 5, 5, 5};
        int[] movementCycleX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        tickCount = 0;
    }
}
