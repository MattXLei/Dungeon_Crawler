package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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
        playerVM.setLocation(screenWidth/2 - 100, screenHeight/2 -100);
        playerView = new PlayerView(this, playerVM.getLocation(), BitmapFactory.decodeResource(getResources(), R.drawable.knight));
        if (character == 1) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.rogue));
        } else if (character == 2) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.mage));
        }

        playerVM.startScore();
        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room2);
        super.setPlayerView(playerView);
        gameLayout.addView(super.playerView);
        playerVM.setLocation(getIntent().getIntExtra("startx", 500), 800);
        handler.post(update);
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
        handler.removeCallbacks(update);
        finish();
    }

}