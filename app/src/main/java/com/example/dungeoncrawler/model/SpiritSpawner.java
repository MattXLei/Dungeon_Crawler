package com.example.dungeoncrawler.model;

public class SpiritSpawner extends Spawner{
    @Override
    public Enemy createEnemy() {
        return new Spirit();
    }
}
