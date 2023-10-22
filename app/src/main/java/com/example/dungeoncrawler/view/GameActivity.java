package com.example.dungeoncrawler.view;

import android.graphics.BitmapFactory;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

public class GameActivity extends AppCompatActivity {
    private int screenWidth, screenHeight;
    protected PlayerView playerView;

    private PlayerViewModel playerVM;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_SHIFT_LEFT:
                playerVM.setMovementStrategy(new RunStrategy());
                break;
            case KeyEvent.KEYCODE_W:
                playerVM.getMovementStrategy().moveUp();
                break;
            case KeyEvent.KEYCODE_A:
                playerVM.getMovementStrategy().moveLeft();
                break;
            case KeyEvent.KEYCODE_S:
                playerVM.getMovementStrategy().moveDown();
                break;
            case KeyEvent.KEYCODE_D:
                playerVM.getMovementStrategy().moveRight();
                break;
            default:
                break;
        }
        playerView.updatePosition();
        return false;
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
            playerVM.setMovementStrategy(new WalkStrategy());
        }
        return false;
    }
    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }
}
