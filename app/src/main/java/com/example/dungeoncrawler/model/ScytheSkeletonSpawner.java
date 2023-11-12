package com.example.dungeoncrawler.model;

public class ScytheSkeletonSpawner extends Spawner {
    @Override
    protected Enemy createEnemy(String type) {
        if (type.equals("ScytheSkeleton")) {
            return new ScytheSkeleton();
        } else {
            return null;
        }
    }
}
