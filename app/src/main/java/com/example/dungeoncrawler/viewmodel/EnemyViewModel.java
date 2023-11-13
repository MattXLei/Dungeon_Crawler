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

    public EnemyViewModel() {
//        enemy = Enemy.getEnemy();
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

    public boolean callValidMove(int changeX, int changeY) {
        if (enemy.validMove(changeX, changeY)) {
            return true;
        }
        return false;
    }

    public void addWall(Wall wall) {
        enemy.addObserver(wall);
    }

    public void removeWall(Wall wall) {
        enemy.removeObserver(wall);
    }

    public void removeAllObservers() {
        enemy.removeAllObservers();
    }

    public void notifyObservers() {
        enemy.notifyObservers();
    }
}
