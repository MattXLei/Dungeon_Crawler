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
    public void swordSkeletonTest() {
        Spawner swordSkeletonSpawner = new SwordSkeletonSpawner();

        Enemy enemy = swordSkeletonSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(25, enemy.getDamage());
        assertEquals(20, enemy.getDefense());
        assertEquals(-20, enemy.getxMove());
        assertEquals(0, enemy.getyMove());
    }
    @Test
    public void scytheSkeletonTest() {
        Spawner scytheSkeletonSpawner = new ScytheSkeletonSpawner();

        Enemy enemy = scytheSkeletonSpawner.spawnEnemy();
        assertEquals(120, enemy.getHealth());
        assertEquals(50, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertEquals(0, enemy.getxMove());
        assertEquals(10, enemy.getyMove());
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
    @Test
    public void swordScytheSkeletonTest() {
        Spawner swordSkeletonSpawner = new SwordSkeletonSpawner();
        Spawner scytheSkeletonSpawner = new ScytheSkeletonSpawner();

        Enemy enemy = swordSkeletonSpawner.spawnEnemy();
        assertEquals(100, enemy.getHealth());
        assertEquals(25, enemy.getDamage());
        assertEquals(20, enemy.getDefense());
        assertEquals(-20, enemy.getxMove());
        assertEquals(0, enemy.getyMove());

        enemy = scytheSkeletonSpawner.spawnEnemy();
        assertEquals(120, enemy.getHealth());
        assertEquals(50, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertEquals(0, enemy.getxMove());
        assertEquals(10, enemy.getyMove());

        enemy = swordSkeletonSpawner.spawnEnemy();
        assertFalse(enemy.getHealth() == 120);
        assertFalse(enemy.getDamage() == 50);
        assertFalse(enemy.getDefense() == 10);
        assertFalse(enemy.getxMove() == 0);
        assertFalse(enemy.getyMove() == 10);
    }
}
