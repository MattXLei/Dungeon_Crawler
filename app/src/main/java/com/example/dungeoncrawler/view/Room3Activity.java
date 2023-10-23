package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Leaderboard;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.viewmodel.LeaderboardViewModel;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;

public class Room3Activity extends GameActivity {

    private long leftTime;

    private TextView score;

    private PlayerViewModel playerVM;

    private int screenWidth, screenHeight;

    private PlayerView playerView;
    private LeaderboardViewModel leaderboardVM;

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen3);
        Button endButton = findViewById(R.id.toEnd);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leftTime = playerVM.getScore() * 1000;

        leaderboardVM = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        endButton.setOnClickListener(v -> {
            leaderboardVM.addAttempt();
            launchNextActivity();
        });

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
        playerVM.setLocation(screenWidth/2 - 100, screenHeight/2 - 100);
        playerView = new PlayerView(this, playerVM.getLocation(), BitmapFactory.decodeResource(getResources(), R.drawable.knight));
        if (character == 1) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.rogue));
        } else if (character == 2) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.mage));
        }
        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room3);
        super.setPlayerView(playerView);
        gameLayout.addView(super.playerView);
        playerVM.startScore(score);
        gameLoop();
    }
    public void gameLoop() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkExit();
                    }
                });
            }
        }, 0, 500);
    }
    public void checkExit() {
        if (playerVM.getLocation().getxCord() > 1340) {
            timer.cancel();
            launchNextActivity();
        }
    }
    public void launchNextActivity() {
        Intent intent = new Intent(this, Room1Activity.class);
        startActivity(intent);
        playerVM.endScore();
        finish();
    }
}