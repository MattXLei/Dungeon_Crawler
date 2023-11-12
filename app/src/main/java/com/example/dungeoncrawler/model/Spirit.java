package com.example.dungeoncrawler.model;

public class Spirit extends Enemy {
    Spirit() {
        health = 100;
        xMove = 25;
        yMove = -25;
        defense = 10;
        damage = 10;
        location = new Location(0, 0);
    }
}
