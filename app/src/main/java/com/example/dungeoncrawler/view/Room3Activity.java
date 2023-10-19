package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Leaderboard;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class Room3Activity extends AppCompatActivity {

    private long leftTime;

    private TextView score;

    private PlayerViewModel playerVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen3);
        Button endButton = findViewById(R.id.toEnd);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leftTime = playerVM.getScore() * 1000;

        endButton.setOnClickListener(v -> {
            Leaderboard.addAttempt();
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
        playerVM.startScore(score);
    }

    public void launchNextActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
        playerVM.endScore();
        finish();
    }
}