package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.model.Wall;
import com.example.dungeoncrawler.viewmodel.LeaderboardViewModel;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

public class Room3Activity extends GameActivity {

    private long leftTime;

    private TextView score;

    private PlayerViewModel playerVM;

    private int screenWidth;
    private int screenHeight;

    private PlayerView playerView;

    private Wall up;

    private Wall down;
    private LeaderboardViewModel leaderboardVM;

    private Handler handler = new Handler();
    private Runnable update = new Runnable() {
        @Override
        public void run() {
            score.setText("Score: " + playerVM.getScore());
            handler.postDelayed(this, 50);
            checkExit();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen3);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leftTime = playerVM.getScore() * 1000;

        leaderboardVM = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        TextView name = findViewById(R.id.nameText);
        TextView difficulty = findViewById(R.id.difficultyText);
        TextView health = findViewById(R.id.healthText);

        score = findViewById(R.id.scoreText);

        Intent settings = getIntent();


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

        up = new Wall(new Location(0, 380), new Location(1000, 380),
                3);
        playerVM.addWall(up);

        down = new Wall(new Location(0, 970), new Location(1000, 970),
                1);
        playerVM.addWall(down);

        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room3);
        super.setPlayerView(playerView);
        gameLayout.addView(super.playerView);

        playerVM.startScore();
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

    private void checkExit() {
        float x = playerVM.getLocation().getxCord();
        if (x >= 950) {
            leaderboardVM.addAttempt();
            launchEndActivity();
        } else if (x <= 0) {
            launchPreviousActivity();
        }
    }
    public void launchPreviousActivity() {
        Intent intent = new Intent(this, Room2Activity.class);
        intent.putExtra("startx", 900);
        startActivity(intent);
        playerVM.endScore();
        handler.removeCallbacks(update);
        finish();
    }
    public void launchEndActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
        playerVM.endScore();
        playerVM.removeWall(up);
        playerVM.removeWall(down);
        handler.removeCallbacks(update);
        finish();
    }
}


