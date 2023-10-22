package com.example.dungeoncrawler.viewmodel;


import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.MovementStrategy;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.WalkStrategy;

public class PlayerViewModel extends ViewModel {

    private Player player;
    private boolean charSelected;
    private CountDownTimer timer;
    private long leftTime;

    public PlayerViewModel() {
        player = Player.getPlayer();
        charSelected = false;
        leftTime = player.getScore() * 1000;
        player.setMovementStrategy(new WalkStrategy());
    }

    public void setCharacter(int num) {
        player.setCharacter(num);
        charSelected = true;
    }

    public int getCharacter() {
        return player.getCharacter();
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            return;
        }
        player.setName(name);
    }

    public String getName() {
        return player.getName();
    }

    public void setScore(int i) {
        player.setScore(Math.max(i, 0));
    }

    public long getScore() {
        return player.getScore();
    }

    public void decreaseScore(long i) {
        player.decreaseScore(i);
    }

    public void setDifficulty(int diff) {
        player.setDifficulty(diff);
        if (diff == 3) {
            player.setHealth(50);
        } else if (diff == 2) {
            player.setHealth(75);
        } else {
            player.setHealth(100);
        }
    }

    public int getDifficulty() {
        return player.getDifficulty();
    }

    public boolean getCharSelected() {
        return charSelected;
    }

    public int getHealth() {
        return player.getHealth();
    }

    public void startScore() {
        timer = new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long remaining) {
                leftTime = remaining;
                decreaseScore(1);
            }

            @Override
            public void onFinish() {}
        }.start();
    }
    public void endScore() {
        timer.cancel();
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        player.setMovementStrategy(movementStrategy);
    }

    public MovementStrategy getMovementStrategy() {
        Log.d("get ms", "Getting movement strategy");
        return player.getMovementStrategy();
    }

    public void setDefaultMovementStrategy() {
        player.setMovementStrategy(new WalkStrategy());
    }

    public void setLocation(int x, int y) {
        player.setLocation(x, y);
    }

    public Location getLocation() {
        return player.getLocation();
    }
}
