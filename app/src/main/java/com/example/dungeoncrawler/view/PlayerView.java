package com.example.dungeoncrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.Player;

public class PlayerView extends View {
    Location location;



    private Bitmap sprite;
    public PlayerView(Context context, Location location, Bitmap sprite) {
        super(context);
        this.location = location;
        this.sprite = sprite;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(sprite, location.getxCord(), location.getyCord(), null);
    }

    public void updatePosition() {
        this.location = Player.getLocation();
        invalidate();
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }
}
