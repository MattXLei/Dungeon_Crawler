package com.example.dungeoncrawler.model;

public class Spirit extends Enemy {
    Spirit() {
        health = 100;
        speed = 20;
        defense = 10;
        damage = 10;
        location = new Location(0f, 0f);
    }
}
