package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import android.content.Intent;
//import android.graphics.RectF;
import android.os.Bundle;
//import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
import android.os.CountDownTimer;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

public class GameActivity extends AppCompatActivity {

    private float playerX;
    private float playerY;
    //private Random random = new Random();
    //RelativeLayout gameLayout;
    private int screenWidth;
    private int screenHeight;

    //in milliseconds
    private static final long STARTTIME = 50000;

    private long leftTime = STARTTIME;

    private CountDownTimer timer;

    private TextView score;

    private PlayerViewModel playerVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        Button endButton = findViewById(R.id.toRoom2);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);

        endButton.setOnClickListener(v -> {
            launchNextActivity();
        });

        TextView name = findViewById(R.id.nameText);
        TextView difficulty = findViewById(R.id.difficultyText);
        TextView health = findViewById(R.id.healthText);
        score = findViewById(R.id.scoreText);

        ImageView knight = findViewById(R.id.knightSprite);
        ImageView necromancer = findViewById(R.id.rogueSprite);
        ImageView mage = findViewById(R.id.mageSprite);


        name.setText(playerVM.getName());
        int difficultyNum = playerVM.getDifficulty();
        if (difficultyNum == 2) {
            difficulty.setText("Medium");
        } else if (difficultyNum == 3) {
            difficulty.setText("Hard");
        } else if (difficultyNum == 1) {
            difficulty.setText("Easy");
        }
        health.setText("Health: " + playerVM.getHealth());
        score.setText("Score: " + playerVM.getScore());

        int character = playerVM.getCharacter();
        if (character == 0) {
            necromancer.setVisibility(ImageView.INVISIBLE);
            mage.setVisibility(ImageView.INVISIBLE);
        } else if (character == 1) {
            knight.setVisibility(ImageView.INVISIBLE);
            mage.setVisibility(ImageView.INVISIBLE);
        } else if (character == 2) {
            necromancer.setVisibility(ImageView.INVISIBLE);
            knight.setVisibility(ImageView.INVISIBLE);
        }


        doCountDown();

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

    public void doCountDown() {
        timer = new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long remaining) {
                leftTime = remaining;
                updateScoreText();
            }

            @Override
            public void onFinish() {
                score.setText("Score: 0");
            }
        }.start();

    }

    private void updateScoreText() {
        playerVM.decreaseScore(1);
        score.setText("Score: " + playerVM.getScore());
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
    public void launchNextActivity() {
        Intent intent = new Intent(this, Room2Activity.class);
        startActivity(intent);
        timer.cancel();
        finish();
    }
}