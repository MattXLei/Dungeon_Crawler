package com.example.dungeoncrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.PowerupDecorator;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.HealthDecorator;
import com.example.dungeoncrawler.model.InvulnerableDecorator;
import com.example.dungeoncrawler.model.SpeedDecorator;
import com.example.dungeoncrawler.model.Powerup;

public class PowerUpView extends View {
    private Location location;

    private Powerup powerup;

    private PowerupDecorator powerUpDec;


    private Bitmap sprite;

    public PowerUpView(Context context, Location location, Powerup powerup, PowerupDecorator powerUpDec) {
        super(context);
        this.location = location;
        powerup.setLocation(location.getxCord(), location.getyCord());
        this.powerUpDec = powerUpDec;
        this.powerUpDec = powerUpDec;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setSprite();
        canvas.drawBitmap(sprite, location.getxCord(), location.getyCord(), null);
    }

    public void updatePosition() {
        invalidate();
    }

    //gonna continue to edit
    public void setSprite() {
        if (powerUpDec instanceof HealthDecorator) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.mage_enemy);
        } else if (enemy instanceof ScytheSkeleton) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton_scythe_enemy);
        }  else if (enemy instanceof Spirit) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.spirit_enemy);
        }  else if (enemy instanceof SwordSkeleton) {
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton_sword_enemy);
        }
    }
}
