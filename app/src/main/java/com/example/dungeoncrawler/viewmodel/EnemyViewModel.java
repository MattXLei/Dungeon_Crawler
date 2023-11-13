package com.example.dungeoncrawler.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Enemy;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.Mage;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.ScytheSkeleton;
import com.example.dungeoncrawler.model.Spirit;
import com.example.dungeoncrawler.model.SwordSkeleton;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.model.Wall;

public class EnemyViewModel {

    private Enemy enemy;

    public EnemyViewModel(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void movement() {
        enemy.movement();
    }

    public Location getLocation() {
        return enemy.getLocation();
    }


    public void resetLocation() {
        enemy.setCoords(0, 0);
    }

    public int getHealth() {
        return enemy.getHealth();
    }

    public void setHealth(int health) {
        enemy.setHealth(health);
    }

    public void setDamageMultiplier(int diff) {
        enemy.setDamageMultiplier(diff);
    }


}
