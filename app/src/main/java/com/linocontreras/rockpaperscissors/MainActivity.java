package com.linocontreras.rockpaperscissors;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button reset;
    Button computer;

    Button rock;
    Button paper;
    Button scissors;

    TextView player_score;
    TextView computer_score;

    RockPaperScissorsGame game;

    Vibrator vibrator;

    long pattern[] = {50, 400, 50, 400, 50};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        game = new RockPaperScissorsGame();

        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        computer = findViewById(R.id.computer);
        reset = findViewById(R.id.reset);

        player_score = findViewById(R.id.player_score);
        computer_score = findViewById(R.id.computer_score);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.reset();
                updateGUI();
            }
        });
    }

    public void vibrate(){
        vibrator.vibrate(pattern, -1);
    }

    public void updateGUI(){
        player_score.setText("Player: " + game.getPlayerScore());
        computer_score.setText("Computer: " + game.getComputerScore());
        computer.setText(game.getLastComputerChoice());

    }

    @Override
    public void onClick(View v){
        int choice, result;
        if(v == rock){
            choice = 0;
        } else if(v == paper){
            choice = 1;
        } else {
            choice = 2;
        }

        result = game.play(choice);

        if(result == 1){
            Toast.makeText(getApplicationContext(), "Player wins!", Toast.LENGTH_SHORT).show();
            vibrate();
        } else if(result == 2){
            Toast.makeText(getApplicationContext(), "Computer wins!", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "It's a tie!", Toast.LENGTH_SHORT).show();
        }
        updateGUI();
    }


}
