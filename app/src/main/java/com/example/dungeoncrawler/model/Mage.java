package com.example.dungeoncrawler.model;

public class Mage extends Enemy {
    Mage() {
        health = 100;
        speed = 10;
        defense = 10;
        damage = 15;
        location = new Location(0f, 0f);
    }
}
