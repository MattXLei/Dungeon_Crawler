package com.example.dungeoncrawler.model;

public class Mage extends Enemy {
    Mage() {
        health = 100;
        xMove = -15;
        yMove = 15;
        defense = 10;
        damage = 15;
        location = new Location(0f, 0f);
    }
}
