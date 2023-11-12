package com.example.dungeoncrawler.model;

public class MageSpawner extends Spawner {
    @Override
    protected Enemy createEnemy(String type) {
        if (type.equals("Mage")) {
            return new Mage();
        } else {
            return null;
        }
    }
}
