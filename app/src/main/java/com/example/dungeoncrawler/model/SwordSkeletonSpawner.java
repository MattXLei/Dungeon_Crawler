package com.example.dungeoncrawler.model;

public class SwordSkeletonSpawner extends Spawner{
    @Override
    public Enemy createEnemy() {
        return new SwordSkeleton();
    }


}
