package com.example.dungeoncrawler.model;

public class SwordSkeleton extends Enemy {
    SwordSkeleton() {
        health = 100;
        xMove = -20;
        yMove = 0;
        defense = 20;
        damage = 25;
        location = new Location(0, 0);
    }
}
