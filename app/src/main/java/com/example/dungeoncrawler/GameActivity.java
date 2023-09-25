package com.example.dungeoncrawler;
import android.content.Intent;
//import android.graphics.RectF;
import android.os.Bundle;
//import android.util.Log;
import android.view.KeyEvent;
//import android.widget.RelativeLayout;
//import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private float playerX;
    private float playerY;
    //private Random random = new Random();
    //RelativeLayout gameLayout;
    private int screenWidth;
    private int screenHeight;
    private Timer dotTimer;
    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        /*screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        // Spawn player in middle of screen
        playerX = screenWidth / 2;
        playerY = screenHeight / 2;

        // Get difficulty selected from Main screen.
        difficulty = getIntent().getDoubleExtra("difficulty", 1);
        // Create dot list
        // initializeDots();
        // Draw dots on screen
        // drawDots();

        dotTimer = new Timer();
        dotTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Loop for checks and assurances that need to run consistently
                    }
                });
            }
        }, 0, 500); // Check every .5 seconds*/
    }

    // Handle key events to move the player
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                playerY -= 50;
                break;
            case KeyEvent.KEYCODE_A:
                playerX -= 50;
                break;
            case KeyEvent.KEYCODE_S:
                playerY += 50;
                break;
            case KeyEvent.KEYCODE_D:
                playerX += 50;
                break;
            default:
                break;
        }
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        if (playerX < 0) {
            playerX = 0;
        }
        if (playerX > screenWidth) {
            playerX = screenWidth;
        }
        if (playerY < 0) {
            playerY = 0;
        }
        if (playerY > screenHeight) {
            playerY = screenHeight;
        }
        return true;
    }

    /*
    private void checkCollisions() {
        for (int i = 0; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (dot.isVisible() && isCollision(playerView, dot)) {
                dot.setInvisible();
                gameLayout.removeView(dotViewMap.get(dot));
                dots.remove(i);
                dotCount++;

                dotCountTextView.setText("Dots Collected: " + dotCount);
                if (dotCount >= dotsToWin) {
                    launchEndActivity();
                }
            } else if (dot.isExpired()) {

            }
        }
    }
     */

    /*
    Method that has logic to detect collisions.
    private boolean isCollision(PlayerView playerView, Dot dot) {
        float playerX = playerView.getX();
        float playerY = playerView.getY();
        int playerRadius = playerView.getRadius();
        float dotX = dot.getX();
        float dotY = dot.getY();
        int dotRadius = dot.getRadius();
        return playerRect.intersect(dotRect);
    }
     */

    // Changes game screen to EndActivity
    private void launchEndActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
        finish();
    }
}