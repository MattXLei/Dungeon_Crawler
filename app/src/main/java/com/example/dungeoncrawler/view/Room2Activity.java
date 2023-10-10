package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Room2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);
        Button nextBtn = findViewById(R.id.homeButton); // change button resource

        // Sends player to Room3
        nextBtn.setOnClickListener(v -> {
            Intent start = new Intent(this, Room3Activity.class);
            startActivity(start);
            finish();
        });
    }
}