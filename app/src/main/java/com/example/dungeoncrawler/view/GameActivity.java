package com.example.dungeoncrawler.view;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

public class GameActivity extends AppCompatActivity {
    private int screenWidth, screenHeight;
    protected PlayerView playerView;

    private Player player = Player.getPlayer();      //temporary solution
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_SHIFT_LEFT:
                player.setMovementStrategy(new RunStrategy());
                break;
            case KeyEvent.KEYCODE_W:
                player.moveUp();
                break;
            case KeyEvent.KEYCODE_A:
                player.moveLeft();
                break;
            case KeyEvent.KEYCODE_S:
                player.moveDown();
                break;
            case KeyEvent.KEYCODE_D:
                player.moveRight();
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
            player.setMovementStrategy(new WalkStrategy());
        }
        return false;
    }
    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }
}
