package com.example.dungeoncrawler.model;

public class SwordSkeleton extends Enemy {
    SwordSkeleton() {
        health = 100;
        speed = 10;
        defense = 20;
        damage = 25;
        location = new Location(0f, 0f);
    }
}
