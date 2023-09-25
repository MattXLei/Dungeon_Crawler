package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;


public class PreGameConfiguration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsscreen);
        Button startBtn = findViewById(R.id.beginButton);


        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);

            switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
            case 1:
                ConfigureVar.setDifficulty(0.5);
                break;
            case 2:
                ConfigureVar.setDifficulty(0.75);
                break;
            case 3:
                ConfigureVar.setDifficulty(1);
                break;
            default:
                ConfigureVar.setDifficulty(0.5);
                break;
            }

            TextInputLayout textInputLayout = findViewById(R.id.playerName);
            Player.setName(String.valueOf(textInputLayout.getEditText().getText()));
            Intent game = new Intent(PreGameConfiguration.this, GameActivity.class);
            startActivity(game);
            finish();
        });
    }
}
