package com.example.dungeoncrawler.model;

public class ScytheSkeleton extends Enemy {
    ScytheSkeleton() {
        health = 120;
        speed = 10;
        defense = 10;
        damage = 50;
        location = new Location(0f, 0f);
    }
}
