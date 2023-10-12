package com.example.dungeoncrawler.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawler.model.Attempt;
import com.example.dungeoncrawler.model.Leaderboard;
public class LeaderboardViewModel extends ViewModel {
    private Leaderboard leaderboard;

    public void addAttempt() {
        Leaderboard.addAttempt();
    }

    public Attempt[] getAttempts() {
        return Leaderboard.getAttempts();
    }

    public Attempt getMostRecent() {
        return Leaderboard.getMostRecent();
    }

    public void empty() {
        Leaderboard.empty();
    }
}
