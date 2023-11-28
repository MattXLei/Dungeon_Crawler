package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;

import com.example.dungeoncrawler.model.DamageDecorator;
import com.example.dungeoncrawler.model.HealthDecorator;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.Powerup;
import com.example.dungeoncrawler.model.Powerupable;
import com.example.dungeoncrawler.model.SpeedDecorator;

import org.junit.Test;

public class PowerupTest {
    Player player = Player.getPlayer();
    int baseHealth = player.getHealth();
    int baseSpeed = player.getSpeed();
    int baseDamage = player.getDamage();
    @Test
    public void baseTest() {
        Powerup base = new Powerup(new Location(0, 0));
        player.setPowerup(base);
        assertEquals(baseHealth, player.getHealth());
        assertEquals(baseSpeed, player.getSpeed());
        assertEquals(baseDamage, player.getDamage());
    }

    @Test
    public void healthTest() {
        Powerup base = new Powerup(new Location(0, 0));
        HealthDecorator health = new HealthDecorator(base);
        player.setPowerup(health);
        assertEquals(baseHealth + 20, player.getHealth());
        assertEquals(baseSpeed, player.getSpeed());
        assertEquals(baseDamage, player.getDamage());
    }

    @Test
    public void SpeedTest() {
        Powerup base = new Powerup(new Location(0, 0));
        SpeedDecorator speed = new SpeedDecorator(base);
        player.setPowerup(speed);
        assertEquals(baseHealth, player.getHealth());
        assertEquals(baseSpeed + 10, player.getSpeed());
        assertEquals(baseDamage, player.getDamage());
    }

    @Test
    public void DamageTest() {
        Powerup base = new Powerup(new Location(0, 0));
        DamageDecorator damage = new DamageDecorator(base);
        player.setPowerup(damage);
        assertEquals(baseHealth, player.getHealth());
        assertEquals(baseSpeed, player.getSpeed());
        assertEquals(baseDamage + 40, player.getDamage());
    }

    @Test
    public void AllTest() {
        Powerup base = new Powerup(new Location(0, 0));
        SpeedDecorator all = new SpeedDecorator(new DamageDecorator(new HealthDecorator(base)));
        player.setPowerup(all);
        assertEquals(baseHealth + 20, player.getHealth());
        assertEquals(baseSpeed + 10, player.getSpeed());
        assertEquals(baseDamage + 40, player.getDamage());
    }

    @Test
    public void MultipleSpeedTest() {
        Powerup base = new Powerup(new Location(0, 0));
        SpeedDecorator temp = new SpeedDecorator(new SpeedDecorator(new SpeedDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseSpeed + 30, player.getSpeed());
    }

    @Test
    public void MultipleDamageTest() {
        Powerup base = new Powerup(new Location(0, 0));
        DamageDecorator temp = new DamageDecorator(new DamageDecorator(new DamageDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseDamage + 120, player.getDamage());
    }

    @Test
    public void MultipleHealthTest() {
        Powerup base = new Powerup(new Location(0, 0));
        HealthDecorator temp = new HealthDecorator(new HealthDecorator(new HealthDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseHealth + 60, player.getHealth());
    }

    @Test
    public void HealthAdditionTest() {
        Powerup base = new Powerup(new Location(0, 0));
        HealthDecorator temp = new HealthDecorator(new HealthDecorator(new HealthDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseHealth + 60, player.getHealth());
        temp = new HealthDecorator(new SpeedDecorator(new HealthDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseHealth + 100, player.getHealth());
        assertEquals(baseSpeed + 10, player.getSpeed());
    }

    @Test
    public void DamageAdditionTest() {
        Powerup base = new Powerup(new Location(0, 0));
        DamageDecorator temp = new DamageDecorator(new DamageDecorator(new DamageDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseDamage + 120, player.getDamage());
        temp = new DamageDecorator(new HealthDecorator(new DamageDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseDamage + 200, player.getDamage());
        assertEquals(baseHealth + 20, player.getHealth());
    }

    @Test
    public void SpeedAdditionTest() {
        Powerup base = new Powerup(new Location(0, 0));
        SpeedDecorator temp = new SpeedDecorator(new SpeedDecorator(new SpeedDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseSpeed + 30, player.getSpeed());
        temp = new SpeedDecorator(new DamageDecorator(new SpeedDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseSpeed + 50, player.getSpeed());
        assertEquals(baseDamage + 40, player.getDamage());
    }

    @Test
    public void ChangeTest() {
        Powerup base = new Powerup(new Location(0, 0));
        HealthDecorator temp = new HealthDecorator(new HealthDecorator(new HealthDecorator(base)));
        player.setPowerup(temp);
        assertEquals(baseHealth + 60, player.getHealth());
        SpeedDecorator temp2 = new SpeedDecorator(new SpeedDecorator(new SpeedDecorator(base)));
        player.setPowerup(temp2);
        assertEquals(baseSpeed + 30, player.getSpeed());
        assertEquals(baseHealth + 60, player.getHealth());
    }
}
