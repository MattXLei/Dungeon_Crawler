package com.example.dungeoncrawler.view;

import android.graphics.BitmapFactory;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

public class GameActivity extends AppCompatActivity {
    private int screenWidth, screenHeight;
    protected PlayerView playerView;

    private PlayerViewModel playerVM;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                Player.getMovementStrategy().moveUp();
                break;
            case KeyEvent.KEYCODE_A:
                Player.getMovementStrategy().moveLeft();
                break;
            case KeyEvent.KEYCODE_S:
                Player.getMovementStrategy().moveDown();
                break;
            case KeyEvent.KEYCODE_D:
                Player.getMovementStrategy().moveRight();
                break;
            default:
                break;
        }
        playerView.updatePosition();
        return false;
    }

    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }
}
