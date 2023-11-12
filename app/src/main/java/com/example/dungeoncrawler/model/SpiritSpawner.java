package com.example.dungeoncrawler.model;

public class SpiritSpawner extends Spawner {
    @Override
    protected Enemy createEnemy(String type) {
        if (type.equals("Spirit")) {
            return new Spirit();
        } else {
            return null;
        }
    }
}
