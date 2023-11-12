package com.example.dungeoncrawler.model;

public abstract class Spawner {
    public Enemy spawnEnemy(String type) {
        Enemy enemy;

        enemy = createEnemy(type);
        return enemy;
    }
    abstract Enemy createEnemy(String type);
}
