package com.example.dungeoncrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Enemy;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.Mage;
import com.example.dungeoncrawler.model.ScytheSkeleton;
import com.example.dungeoncrawler.model.Spirit;
import com.example.dungeoncrawler.model.SwordSkeleton;
import com.example.dungeoncrawler.model.Wall;

public class EnemyView extends View {
    private Location location;

    private Enemy enemy;


    private Bitmap sprite;

    public EnemyView(Context context, Location location, Enemy enemy) {
        super(context);
        this.location = location;
        this.enemy = enemy;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setSprite();
        canvas.drawBitmap(sprite, location.getxCord(), location.getyCord(), null);
    }

    public void updatePosition() {
        this.location = enemy.getLocation();
        invalidate();
    }

    public void setSprite() {
        if (enemy instanceof Mage) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.mage_enemy);
        } else if (enemy instanceof ScytheSkeleton) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton_scythe_enemy);
        }  else if (enemy instanceof Spirit) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.spirit_enemy);
        }  else if (enemy instanceof SwordSkeleton) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton_sword_enemy);
        }
    }

    public int getHealth() {
        return enemy.getHealth();
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


