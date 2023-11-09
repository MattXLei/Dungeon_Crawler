package com.example.dungeoncrawler.model;

public class ScytheSkeletonSpawner extends Spawner{
    @Override
    public Enemy createEnemy() {
        return new ScytheSkeleton();
    }
}
