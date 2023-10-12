package com.example.dungeoncrawler.viewmodel;


import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawler.model.Player;

public class PlayerViewModel extends ViewModel {

    private Player player;
    private boolean charSelected;

    public PlayerViewModel() {
        player = Player.getPlayer();
        charSelected = false;
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
}
