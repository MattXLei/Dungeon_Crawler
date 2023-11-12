package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.model.Wall;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

public class Room2Activity extends GameActivity {

    private float playerX;
    private float playerY;
    private int screenWidth;
    private int screenHeight;

    private long leftTime;

    private TextView score;

    private PlayerViewModel playerVM;

    private PlayerView playerView;

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
        setContentView(R.layout.gamescreen2);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leftTime = playerVM.getScore() * 1000;

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

        //upper left up wall
        Wall up1 = new Wall(new Location (-20, 600), new Location(150, 600), 3);
        playerVM.addWall(up1);
        //upper left left wall
        Wall left1 = new Wall(new Location(150, 380), new Location(150, 600), 2);
        playerVM.addWall(left1);
        //upper middle wall
        Wall up2 = new Wall(new Location(0, 380), new Location(1000, 380),
                3);
        playerVM.addWall(up2);
        //upper right right wall
        Wall right1 = new Wall(new Location(775, 380), new Location(775, 600), 0);
        playerVM.addWall(right1);
        //upper right up wall
        Wall up3 = new Wall(new Location(775, 600), new Location(1000, 600), 3);
        playerVM.addWall(up3);

        //lower left down wall
        Wall down1 = new Wall(new Location(-20, 950), new Location (150, 950), 1);
        playerVM.addWall(down1);
        //lower left left wall
        Wall left2 = new Wall(new Location(150, 950), new Location(150, 1175), 2);
        playerVM.addWall(left2);
        //middle down wall
        Wall down2 = new Wall(new Location(0, 1150), new Location(1000, 1150), 1);
        playerVM.addWall(down2);
        //lower right right wall
        Wall right2 = new Wall(new Location(775, 950), new Location(775, 1175), 0);
        playerVM.addWall(right2);
        //lower right down wall
        Wall down3 = new Wall(new Location(775, 950), new Location(1000, 950), 1);
        playerVM.addWall(down3);

        playerVM.startScore();
        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room2);
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
        if (playerVM.getLocation().getxCord() < 0) {
            launchPreviousActivity();
        }
        if (playerVM.getLocation().getxCord() > 950) {
            launchNextActivity();
        }
    }
    public void launchPreviousActivity() {
        Intent intent = new Intent(this, Room1Activity.class);
        intent.putExtra("startx", 900);
        startActivity(intent);
        playerVM.endScore();
        handler.removeCallbacks(update);
        finish();
    }
    public void launchNextActivity() {
        Intent intent = new Intent(this, Room3Activity.class);
        intent.putExtra("startx", 50);
        startActivity(intent);
        playerVM.endScore();
        playerVM.removeAllObservers();
        handler.removeCallbacks(update);
        finish();
    }

}