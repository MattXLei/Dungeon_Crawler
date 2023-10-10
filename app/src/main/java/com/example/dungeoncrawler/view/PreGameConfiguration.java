package com.example.dungeoncrawler.view;

import com.example.dungeoncrawler.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dungeoncrawler.model.Player;
import com.google.android.material.textfield.TextInputLayout;


public class PreGameConfiguration extends AppCompatActivity {
    private boolean charSelected;
    private int diff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsscreen);
        Button startBtn = findViewById(R.id.beginButton);
        TextInputLayout textInputLayout = findViewById(R.id.nameInputLayout);
        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        ImageButton knight = findViewById(R.id.knightButton);
        ImageButton necromancer = findViewById(R.id.necromancerButton);
        ImageButton mage = findViewById(R.id.mageButton);
        charSelected = false;

        knight.setOnClickListener(view -> {
            Player.setCharacter(0);
            setChar();
            necromancer.setSelected(false);
            mage.setSelected(false);
        });

        necromancer.setOnClickListener(view -> {
            Player.setCharacter(1);
            setChar();
            knight.setSelected(false);
            mage.setSelected(false);
        });

        mage.setOnClickListener(view -> {
            Player.setCharacter(2);
            setChar();
            necromancer.setSelected(false);
            knight.setSelected(false);
        });

        RadioButton easy = findViewById(R.id.easyButton);
        RadioButton medium = findViewById(R.id.mediumButton);
        RadioButton hard = findViewById(R.id.hardButton);

        easy.setOnClickListener(v -> {
            setDiff(1);
        });
        medium.setOnClickListener(v -> {
            setDiff(2);
        });
        hard.setOnClickListener(v -> {
            setDiff(3);
        });

        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            String name = textInputLayout.getEditText().getText().toString().trim();
            boolean invalid = TextUtils.isEmpty(name)
                    || difficultyRadioGroup.getCheckedRadioButtonId() == -1 || !charSelected;

            if (!invalid) {
                Player.setName(name);
                Intent game = new Intent(PreGameConfiguration.this, GameActivity.class);
                game.putExtra("name", Player.getName());
                game.putExtra("character", Player.getCharacter());
                game.putExtra("difficulty", diff);
                startActivity(game);
                finish();
            }
        });
    }

    private void setChar() {
        charSelected = true;
    }

    private void setDiff(int d) {
        diff = d;
    }
}
