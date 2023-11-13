package com.example.dungeoncrawler.model;

public class SwordSkeleton extends Enemy {
    SwordSkeleton() {
        health = 100;
        defense = 20;
        damage = 15;
        location = new Location(0, 0);
        int[] movementCycleX = {-5, -5, -5, -5, 5, 5, 5, 5};
        int[] movementCycleY = {-5, -5, -5, -5, 5, 5, 5, 5};
        tickCount = 0;
    }
}
