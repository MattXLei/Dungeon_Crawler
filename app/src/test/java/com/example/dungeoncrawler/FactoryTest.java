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
        assertEquals(25, enemy.getxMove());
        assertEquals(-25, enemy.getyMove());
    }
    @Test
    public void mageTest() {
        Spawner mageSpawner = new MageSpawner();

        Enemy enemy = mageSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(15, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertEquals(-15, enemy.getxMove());
        assertEquals(15, enemy.getyMove());
    }
    @Test
    public void spiritMageTest() {
        Spawner spiritSpawner = new SpiritSpawner();
        Spawner mageSpawner = new MageSpawner();

        Enemy enemy = spiritSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(10, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertEquals(25, enemy.getxMove());
        assertEquals(-25, enemy.getyMove());

        enemy = mageSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(15, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertEquals(-15, enemy.getxMove());
        assertEquals(15, enemy.getyMove());

        enemy = spiritSpawner.spawnEnemy();
        assertFalse(enemy.getHealth() != 100);
        assertFalse(enemy.getDamage() == 15);
        assertFalse(enemy.getDefense() != 10);
        assertFalse(enemy.getxMove() == -15);
        assertFalse(enemy.getyMove() == 15);
    }
}
