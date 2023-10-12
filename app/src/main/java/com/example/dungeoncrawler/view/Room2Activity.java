package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Player;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Room2Activity extends AppCompatActivity {

    private float playerX;
    private float playerY;
    private int screenWidth;
    private int screenHeight;

    private long leftTime = Player.getScore() * 1000;

    private CountDownTimer timer;

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen2);
        Button endButton = findViewById(R.id.toRoom3);

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

        Intent settings = getIntent();


        name.setText(Player.getName());
        int difficultyNum = Player.getDifficulty();
        if (difficultyNum == 2) {
            difficulty.setText("Medium");
        } else if (difficultyNum == 3) {
            difficulty.setText("Hard");
        } else if (difficultyNum == 1) {
            difficulty.setText("Easy");
        }
        health.setText("Health: " + Player.getHealth());
        score.setText("Score: " + Player.getScore());

        int character = Player.getCharacter();
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
    }

    public void launchNextActivity() {
        Intent intent = new Intent(this, Room3Activity.class);
        startActivity(intent);
        finish();
        timer.cancel();
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
        Player.decreaseScore(1);
        score.setText("Score: " + Player.getScore());
    }
}