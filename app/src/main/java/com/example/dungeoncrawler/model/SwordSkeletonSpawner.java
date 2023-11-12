package com.example.dungeoncrawler.model;

public class SwordSkeletonSpawner extends Spawner {
    @Override
    protected Enemy createEnemy(String type) {
        if (type.equals("SwordSkeleton")) {
            return new SwordSkeleton();
        } else {
            return null;
        }
    }
}
