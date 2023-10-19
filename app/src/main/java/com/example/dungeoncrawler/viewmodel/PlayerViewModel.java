package com.example.dungeoncrawler.viewmodel;


import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawler.model.Player;

public class PlayerViewModel extends ViewModel {

    private Player player;
    private boolean charSelected;
    private CountDownTimer timer;
    private long leftTime;

    public PlayerViewModel() {
        player = Player.getPlayer();
        charSelected = false;
        leftTime = Player.getScore() * 1000;
    }

    public void setCharacter(int num) {
        Player.setCharacter(num);
        charSelected = true;
    }

    public int getCharacter() {
        return Player.getCharacter();
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            return;
        }
        Player.setName(name);
    }

    public String getName() {
        return Player.getName();
    }

    public void setScore(int i) {
        Player.setScore(Math.max(i, 0));
    }

    public long getScore() {
        return Player.getScore();
    }

    public void decreaseScore(long i) {
        Player.decreaseScore(i);
    }

    public void setDifficulty(int diff) {
        Player.setDifficulty(diff);
        if (diff == 3) {
            Player.setHealth(50);
        } else if (diff == 2) {
            Player.setHealth(75);
        } else {
            Player.setHealth(100);
        }
    }

    public int getDifficulty() {
        return Player.getDifficulty();
    }

    public boolean getCharSelected() {
        return charSelected;
    }

    public int getHealth() {
        return Player.getHealth();
    }

    public void startScore(TextView score) {
        timer = new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long remaining) {
                leftTime = remaining;
                decreaseScore(1);
                score.setText("Score: " + getScore());
            }

            @Override
            public void onFinish() {}
        }.start();
    }

    public void endScore() {
        timer.cancel();
    }
}
