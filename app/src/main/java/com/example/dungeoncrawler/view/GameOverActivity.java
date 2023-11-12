package com.example.dungeoncrawler.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodel.LeaderboardViewModel;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

public class GameOverActivity extends AppCompatActivity {

    private LeaderboardViewModel leaderboardVM;
    private PlayerViewModel playerVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameoverscreen);
        Button exitBtn = findViewById(R.id.homeButton2); // change button resource

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leaderboardVM = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        // Exits app to welcome activity
        exitBtn.setOnClickListener(v -> {
            Intent start = new Intent(this, WelcomeActivity.class);
            startActivity(start);
            finish();
        });

        TextView lb1 = findViewById(R.id.LB12);
        TextView lb2 = findViewById(R.id.LB22);
        TextView lb3 = findViewById(R.id.LB32);
        TextView lb4 = findViewById(R.id.LB42);
        TextView lb5 = findViewById(R.id.LB52);

        if (leaderboardVM.getAttempts()[0] != null) {
            lb1.setText(leaderboardVM.getAttempts()[0].toString());
        }
        if (leaderboardVM.getAttempts()[1] != null) {
            lb2.setText(leaderboardVM.getAttempts()[1].toString());
        }
        if (leaderboardVM.getAttempts()[2] != null) {
            lb3.setText(leaderboardVM.getAttempts()[2].toString());
        }
        if (leaderboardVM.getAttempts()[3] != null) {
            lb4.setText(leaderboardVM.getAttempts()[3].toString());
        }
        if (leaderboardVM.getAttempts()[4] != null) {
            lb5.setText(leaderboardVM.getAttempts()[4].toString());
        }
    }
}
