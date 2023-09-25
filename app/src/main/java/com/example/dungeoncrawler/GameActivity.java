package com.example.dungeoncrawler;
import android.content.Intent;
//import android.graphics.RectF;
import android.os.Bundle;
//import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {


    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        playerX = screenWidth / 2;
        playerY = screenHeight / 2;
        Button endScreenBtn = findViewById(R.id.endScreenButton); // change button resource

        // Starts app on click
        endScreenBtn.setOnClickListener(v -> {
            Intent end = new Intent(this, EndActivity.class);
            startActivity(end);
        });

        // Get difficulty selected from Main screen.
        difficulty = getIntent().getDoubleExtra("difficulty", 1);

        TextView textView = findViewById(R.id.healthText);
        textView.append(" " +  ConfigureVar.getDifficulty());


        TextView textView2 = findViewById(R.id.nameText);
        textView2.append(Player.getName());

        TextView textView3 = findViewById(R.id.healthText);
        textView3.append("" + Player.getHealth());

    }
        // Handle key events to move the player

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_W:
//                playerY -= 50;
//                break;
//            case KeyEvent.KEYCODE_A:
//                playerX -= 50;
//                break;
//            case KeyEvent.KEYCODE_S:
//                playerY += 50;
//                break;
//            case KeyEvent.KEYCODE_D:
//                playerX += 50;
//                break;
//        }
//        screenWidth = getResources().getDisplayMetrics().widthPixels;
//        screenHeight = getResources().getDisplayMetrics().heightPixels;
//        if (playerX < 0) {
//            playerX = 0;
//        }
//        if (playerX > screenWidth) {
//            playerX = screenWidth;
//        }
//        if (playerY < 0) {
//            playerY = 0;
//        }
//        if (playerY > screenHeight) {
//            playerY = screenHeight;
//        }
//        return true;
//    }

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

    */
//    private boolean isCollision(PlayerView playerView, Dot dot) {
//        float playerX = playerView.getX();
//        float playerY = playerView.getY();
//        int playerRadius = playerView.getRadius();
//        float dotX = dot.getX();
//        float dotY = dot.getY();
//        int dotRadius = dot.getRadius();
//
//            /*
//            Creates a rectangle around dot, and checks for an intersection between player rect and
//            dot rect. Intersection = collision.
//             */
//        RectF playerRect = new RectF(playerX - playerRadius, playerY - playerRadius, playerX + playerRadius, playerY + playerRadius);
//        RectF dotRect = new RectF(dotX - dotRadius, dotY - dotRadius, dotX + dotRadius, dotY + dotRadius);
//
//        return playerRect.intersect(dotRect);
//    }
        //}


}

