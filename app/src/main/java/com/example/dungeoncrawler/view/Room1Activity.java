package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import android.content.Intent;
//import android.graphics.RectF;
import android.graphics.BitmapFactory;
import android.os.Bundle;
//import android.util.Log;
import android.util.Log;
import android.view.KeyEvent;
//import android.widget.Button;
import android.widget.TextView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
import android.os.Handler;

import androidx.lifecycle.ViewModelProvider;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.Wall;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;


import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.dungeoncrawler.model.WalkStrategy;


public class Room1Activity extends GameActivity {

    private float playerX;
    private float playerY;
    private int screenWidth;
    private int screenHeight;

    private TextView score;

    private PlayerViewModel playerVM;

    private PlayerView playerView;

    private TextView temp;

    private Handler handler = new Handler();
    private Runnable update = new Runnable() {
        @Override
        public void run() {
            score.setText("Score: " + playerVM.getScore());
            handler.postDelayed(this, 50);

            checkExit();
            Log.d("Player Location", playerVM.getLocation().getxCord() + "," + playerVM.getLocation().getyCord());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);

        TextView name = findViewById(R.id.nameText);
        TextView difficulty = findViewById(R.id.difficultyText);
        TextView health = findViewById(R.id.healthText);
        score = findViewById(R.id.scoreText);


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


        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        int character = playerVM.getCharacter();
        playerVM.setLocation(screenWidth / 2 - 100, screenHeight / 2 - 100);
        playerView = new PlayerView(this, playerVM.getLocation(),
                BitmapFactory.decodeResource(getResources(), R.drawable.knight));
        if (character == 1) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.rogue));
        } else if (character == 2) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.mage));
        }

        //main upper wall
        Wall wallUp1 = new Wall(new Location(0, 380), new Location(900, 380),
                3);
        playerVM.addWall(wallUp1);
        //right upper wall
        Wall wallRight1 = new Wall(new Location(775, 360), new Location(775, 580), 0);
        playerVM.addWall(wallRight1);
        //smaller upper wall
        Wall wallUp2 = new Wall(new Location(775, 580), new Location(1000, 580), 3);
        playerVM.addWall(wallUp2);
        //main down wall
        Wall wallDown1 = new Wall(new Location(100, 1150), new Location(1000, 1150),
                1);
        //right lower wall
        Wall wallRight2 = new Wall(new Location(775, 950), new Location(775, 1200), 0);
        playerVM.addWall(wallRight2);
        //smaller lower wall
        Wall wallDown2 = new Wall(new Location(775, 950), new Location(1000, 950), 1);
        playerVM.addWall(wallDown2);
        //main lower wall
        playerVM.addWall(wallDown1);
        //main left wall
        Wall left = new Wall(new Location(125, 380), new Location(125, 1300),
                2);
        playerVM.addWall(left);

        playerVM.startScore();

        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room1);
        super.setPlayerView(playerView);
        gameLayout.addView(super.playerView);

        playerVM.setLocation(getIntent().getIntExtra("startx", 500), 800);
        handler.post(update);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_SHIFT_LEFT:
            playerVM.setMovementStrategy(new RunStrategy());
            break;
        case KeyEvent.KEYCODE_W:
            if (playerVM.callValidMove(0, -1 * playerVM.getMovementStrategy().getStep())) {
                playerVM.moveUp();
            }
            break;
        case KeyEvent.KEYCODE_A:
            if (playerVM.callValidMove(-1 * playerVM.getMovementStrategy().getStep(), 0)) {
                playerVM.moveLeft();
            }
            break;
        case KeyEvent.KEYCODE_S:
            if (playerVM.callValidMove(0, playerVM.getMovementStrategy().getStep())) {
                playerVM.moveDown();
            }
            break;
        case KeyEvent.KEYCODE_D:
            if (playerVM.callValidMove(playerVM.getMovementStrategy().getStep(), 0)) {
                playerVM.moveRight();
            }
            break;
        default:
            break;
        }
        playerView.updatePosition();
        playerVM.notifyObservers();
        return false;
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
            playerVM.setMovementStrategy(new WalkStrategy());
        }
        return false;
    }

    public void checkExit() {
        if (playerVM.getLocation().getxCord() > 950) {
            launchNextActivity();
        }
    }
    public void launchNextActivity() {
        Intent intent = new Intent(this, Room2Activity.class);
        intent.putExtra("startx", 50);
        startActivity(intent);
        playerVM.endScore();
        playerVM.removeAllObservers();
        handler.removeCallbacks(update);
        finish();
    }
}