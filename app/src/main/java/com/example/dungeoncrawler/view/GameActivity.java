package com.example.dungeoncrawler.view;

import android.view.KeyEvent;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
import android.os.CountDownTimer;
=======
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6


import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
//import java.util.Timer;
//import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private float playerX;
    private float playerY;
    //private Random random = new Random();
    //RelativeLayout gameLayout;
    private int screenWidth;
    private int screenHeight;
    //    private Timer dotTimer;

    //in milliseconds
    private static final long STARTTIME = 50000;

    private long leftTime = STARTTIME;

    private CountDownTimer timer;

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        Button endButton = findViewById(R.id.toRoom2);

        endButton.setOnClickListener(v -> {
            launchNextActivity();
        });

        TextView name = findViewById(R.id.nameText);
        TextView difficulty = findViewById(R.id.difficultyText);
        TextView health = findViewById(R.id.healthText);
        score = findViewById(R.id.scoreText);

        ImageView knight = findViewById(R.id.knightSprite);
        ImageView necromancer = findViewById(R.id.necroSprite);
        ImageView mage = findViewById(R.id.mageSprite);

        Intent settings = getIntent();


        name.setText(settings.getStringExtra("name"));
        int difficultyNum = settings.getIntExtra("difficulty", 1);
        if (difficultyNum == 2) {
            difficulty.setText("Medium");
        } else if (difficultyNum == 3) {
            difficulty.setText("Hard");
        } else if (difficultyNum == 1) {
            difficulty.setText("Easy");
        }
        health.setText("Health: " + Player.getHealth());
        score.setText("Score: " + Player.getScore());

        int character = Player.getCharacter();
        if (character == 0) {
            necromancer.setVisibility(ImageView.INVISIBLE);
            mage.setVisibility(ImageView.INVISIBLE);
        } else if (character == 1) {
            knight.setVisibility(ImageView.INVISIBLE);
            mage.setVisibility(ImageView.INVISIBLE);
        } else if (character == 2) {
            necromancer.setVisibility(ImageView.INVISIBLE);
            knight.setVisibility(ImageView.INVISIBLE);
        }


        doCountDown();

        /*screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        // Spawn player in middle of screen
        playerX = screenWidth / 2;
        playerY = screenHeight / 2;

        // Get difficulty selected from Main screen.
        difficulty = getIntent().getDoubleExtra("difficulty", 1);
        // Create dot list
        // initializeDots();
        // Draw dots on screen
        // drawDots();

        dotTimer = new Timer();
        dotTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Loop for checks and assurances that need to run consistently
                    }
                });
            }
        }, 0, 500); // Check every .5 seconds*/
    }

    public void doCountDown() {
        timer = new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long remaining) {
                leftTime = remaining;
                updateScoreText();
            }

            @Override
            public void onFinish() {
                score.setText("Score: 0");
            }
        }.start();

    }

    private void updateScoreText() {
        Player.decreaseScore(1);
        score.setText("Score: " + Player.getScore());
    }



    // Handle key events to move the player
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_W:
            playerY -= 50;
            break;
        case KeyEvent.KEYCODE_A:
            playerX -= 50;
            break;
        case KeyEvent.KEYCODE_S:
            playerY += 50;
            break;
        case KeyEvent.KEYCODE_D:
            playerX += 50;
            break;
        default:
            break;
        }
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        if (playerX < 0) {
            playerX = 0;
        }
        if (playerX > screenWidth) {
            playerX = screenWidth;
        }
        if (playerY < 0) {
            playerY = 0;
        }
        if (playerY > screenHeight) {
            playerY = screenHeight;
        }
        return true;
=======
import com.example.dungeoncrawler.model.Player;
import com.example.dungeoncrawler.model.RunStrategy;
import com.example.dungeoncrawler.model.WalkStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private int screenWidth, screenHeight;
    protected PlayerView playerView;

    private Timer timer;

    private Player player = Player.getPlayer();      //temporary solution
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_SHIFT_LEFT:
//                player.setMovementStrategy(new RunStrategy());
//                break;
//            case KeyEvent.KEYCODE_W:
//                if (player.validMove(0, -25))
//                    player.moveUp();
//                break;
//            case KeyEvent.KEYCODE_A:
//                if (player.validMove(-25, 0))
//                    player.moveLeft();
//                break;
//            case KeyEvent.KEYCODE_S:
//                if (player.validMove(0, 25))
//                    player.moveDown();
//                break;
//            case KeyEvent.KEYCODE_D:
//                if (player.validMove(25, 0))
//                    player.moveRight();
//                break;
//            default:
//                break;
//        }
//        playerView.updatePosition();
//        return false;
//    }
//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
//            player.setMovementStrategy(new WalkStrategy());
//        }
//        return false;
//    }
    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
>>>>>>> 7a1f03aa94fd178e71934b14ddb9a03584110ba6
    }

}

