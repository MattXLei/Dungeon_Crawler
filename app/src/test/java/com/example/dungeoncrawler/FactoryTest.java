package com.example.dungeoncrawler;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.model.Enemy;
import com.example.dungeoncrawler.model.Spawner;
import com.example.dungeoncrawler.model.Mage;
import com.example.dungeoncrawler.model.MageSpawner;
import com.example.dungeoncrawler.model.Spirit;
import com.example.dungeoncrawler.model.SpiritSpawner;
import com.example.dungeoncrawler.model.SwordSkeleton;
import com.example.dungeoncrawler.model.SwordSkeletonSpawner;
import com.example.dungeoncrawler.model.ScytheSkeleton;
import com.example.dungeoncrawler.model.ScytheSkeletonSpawner;
public class FactoryTest {
    @Test
    public void spiritTest() {
        Spawner spiritSpawner = new SpiritSpawner();

        Enemy enemy = spiritSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(10, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
    }
}
