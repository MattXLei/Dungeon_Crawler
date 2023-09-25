package com.example.dungeoncrawler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen); // change screen resource
        Button startBtn = findViewById(R.id.start); // change button resource

        // Starts app on click
        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, PreGameConfiguration.class);
            startActivity(intent);
        });

        Button exitBtn = (Button) findViewById(R.id.exit); // change button resource

        // Exits app on click
        exitBtn.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}
