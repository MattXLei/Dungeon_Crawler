package com.example.dungeoncrawler.view;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.model.Enemy;
import com.example.dungeoncrawler.model.Location;
import com.example.dungeoncrawler.model.MageSpawner;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.Spawner;
import com.example.dungeoncrawler.model.SpiritSpawner;
import com.example.dungeoncrawler.model.WalkStrategy;
import com.example.dungeoncrawler.model.Wall;
import com.example.dungeoncrawler.viewmodel.EnemyViewModel;
import com.example.dungeoncrawler.viewmodel.LeaderboardViewModel;
import com.example.dungeoncrawler.viewmodel.PlayerViewModel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

public class Room3Activity extends GameActivity {

    private long leftTime;

    private TextView score;
    private TextView health;

    private PlayerViewModel playerVM;

    private int screenWidth;
    private int screenHeight;

    private PlayerView playerView;
    private EnemyView enemyView1;
    private EnemyView enemyView2;

    private EnemyViewModel enemyVM2;
    private EnemyViewModel enemyVM1;

    private LeaderboardViewModel leaderboardVM;



    private Handler handler = new Handler();
    private Runnable update = new Runnable() {
        @Override
        public void run() {
            enemyVM1.movement();
            enemyView1.updatePosition();
            enemyVM2.movement();
            enemyView2.updatePosition();
            score.setText("Score: " + playerVM.getScore());
            handler.postDelayed(this, 50);
            health.setText("Health: " + playerVM.getHealth());
            checkGameOver();
            checkExit();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen3);

        playerVM = new ViewModelProvider(this).get(PlayerViewModel.class);
        leftTime = playerVM.getScore() * 1000;

        leaderboardVM = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        TextView name = findViewById(R.id.nameText);
        TextView difficulty = findViewById(R.id.difficultyText);
        health = findViewById(R.id.healthText);

        score = findViewById(R.id.scoreText);

        Intent settings = getIntent();


        name.setText(playerVM.getName());
        int difficultyNum = playerVM.getDifficulty();
        if (difficultyNum == 2) {
            difficulty.setText("Medium");
        } else if (difficultyNum == 3) {
            difficulty.setText("Hard");
        } else if (difficultyNum == 1) {
            difficulty.setText("Easy");
        }
        health.setText("Health: " + playerVM.getHealth());
        score.setText("Score: " + playerVM.getScore());

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        int character = playerVM.getCharacter();
        playerVM.setLocation(screenWidth / 2 - 100, screenHeight / 2 - 100);
        playerView = new PlayerView(this, playerVM.getLocation(),
                BitmapFactory.decodeResource(getResources(), R.drawable.knight));
        if (character == 1) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.rogue));
        } else if (character == 2) {
            playerView.setSprite(BitmapFactory.decodeResource(getResources(), R.drawable.mage));
        }

        //upper left up wall
        Wall up1 = new Wall(new Location(-20, 600), new Location(150, 600), 3);
        playerVM.addObserver(up1);
        //upper left left wall
        Wall left1 = new Wall(new Location(150, 380), new Location(150, 600), 2);
        playerVM.addObserver(left1);
        //upper middle wall
        Wall up2 = new Wall(new Location(0, 380), new Location(1000, 380),
                3);
        playerVM.addObserver(up2);
        //upper right right wall
        Wall right1 = new Wall(new Location(775, 380), new Location(775, 600), 0);
        playerVM.addObserver(right1);
        //upper right up wall
        Wall up3 = new Wall(new Location(775, 600), new Location(1000, 600), 3);
        playerVM.addObserver(up3);

        //main down wall
        Wall down = new Wall(new Location(0, 970), new Location(1000, 970),
                1);
        playerVM.addObserver(down);

        playerVM.setMovementStrategy(new WalkStrategy());
        ConstraintLayout gameLayout = findViewById(R.id.room3);
        super.setPlayerView(playerView);
        gameLayout.addView(super.playerView);

        playerVM.startScore();
        playerVM.setLocation(getIntent().getIntExtra("startx", 500), 800);
        handler.post(update);

        createEnemy(gameLayout);

        playerVM.addObserver(enemyVM1.getEnemy());
        playerVM.addObserver(enemyVM2.getEnemy());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_SHIFT_LEFT:
            playerVM.setMovementStrategy(new RunStrategy());
            break;
        case KeyEvent.KEYCODE_W:
            if (playerVM.callValidMove(0, -1 * playerVM.getMovementStrategy().getStep())) {
                playerVM.moveUp();
            }
            break;
        case KeyEvent.KEYCODE_A:
            if (playerVM.callValidMove(-1 * playerVM.getMovementStrategy().getStep(), 0)) {
                playerVM.moveLeft();
            }
            break;
        case KeyEvent.KEYCODE_S:
            if (playerVM.callValidMove(0, playerVM.getMovementStrategy().getStep())) {
                playerVM.moveDown();
            }
            break;
        case KeyEvent.KEYCODE_D:
            if (playerVM.callValidMove(playerVM.getMovementStrategy().getStep(), 0)) {
                playerVM.moveRight();
            }
            break;
        //for testing health and game over
        case KeyEvent.KEYCODE_P:
            playerVM.setHealth(playerVM.getHealth() - 5);
            break;
        default:
            break;
        }
        playerView.updatePosition();
        return false;
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
            playerVM.setMovementStrategy(new WalkStrategy());
        }
        return false;
    }

    private void checkExit() {
        float x = playerVM.getLocation().getxCord();
        if (x >= 950) {
            leaderboardVM.addAttempt();
            launchEndActivity();
        } else if (x <= 0) {
            launchPreviousActivity();
        }
    }
    public void launchPreviousActivity() {
        Intent intent = new Intent(this, Room2Activity.class);
        intent.putExtra("startx", 900);
        startActivity(intent);
        playerVM.endScore();
        handler.removeCallbacks(update);
        finish();
    }
    public void launchEndActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
        playerVM.endScore();
        playerVM.removeAllObservers();
        handler.removeCallbacks(update);
        finish();
    }
    public void checkGameOver() {
        if (playerVM.getHealth() <= 0) {
            launchGameOver();
        }
    }
    public void launchGameOver() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
        playerVM.endScore();
        playerVM.removeAllObservers();
        handler.removeCallbacks(update);
        finish();
    }
    public void createEnemy(ConstraintLayout gameLayout) {
        Spawner spawner = new SpiritSpawner();
        Location temp = new Location(500, 500);
        Enemy enemy1 = spawner.spawnEnemy();
        enemyView1 = new EnemyView(this, temp, enemy1);
        enemyVM1 = new EnemyViewModel(enemy1);
        spawner = new MageSpawner();
        Enemy enemy2 = spawner.spawnEnemy();
        Location temp2 = new Location(500, 900);
        enemyView2 = new EnemyView(this, temp2, enemy2);
        enemyVM2 = new EnemyViewModel(enemy2);
        gameLayout.addView(enemyView1);
        gameLayout.addView(enemyView2);
    }
}


