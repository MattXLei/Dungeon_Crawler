package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.dungeoncrawler.viewmodel.LeaderboardViewModel;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;
public class EndActivity extends AppCompatActivity {

    private LeaderboardViewModel leaderboardVM;
    private PlayerViewModel playerVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);
        Button exitBtn = findViewById(R.id.homeButton); // change button resource

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leaderboardVM = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        // Exits app to welcome activity
        exitBtn.setOnClickListener(v -> {
            Intent start = new Intent(this, WelcomeActivity.class);
            startActivity(start);
            finish();
        });

        TextView lb1 = findViewById(R.id.LB1);
        TextView lb2 = findViewById(R.id.LB2);
        TextView lb3 = findViewById(R.id.LB3);
        TextView lb4 = findViewById(R.id.LB4);
        TextView lb5 = findViewById(R.id.LB5);

        if(Leaderboard.getAttempts()[0] != null) {
            lb1.setText(Leaderboard.getAttempts()[0].toString());
        }
        if(Leaderboard.getAttempts()[1] != null) {
            lb2.setText(Leaderboard.getAttempts()[1].toString());
        }
        if(Leaderboard.getAttempts()[2] != null) {
            lb3.setText(Leaderboard.getAttempts()[2].toString());
        }
        if(Leaderboard.getAttempts()[3] != null) {
            lb4.setText(Leaderboard.getAttempts()[3].toString());
        }
        if(Leaderboard.getAttempts()[4] != null) {
            lb5.setText(Leaderboard.getAttempts()[4].toString());
        }

        TextView recent = findViewById(R.id.textRecent);
        recent.setText(Leaderboard.getMostRecent().toString());
    }
}