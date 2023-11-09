package com.example.dungeoncrawler.model;

public class MageSpawner extends Spawner{
    @Override
    public Enemy createEnemy() {
        return new Mage();
    }
}
