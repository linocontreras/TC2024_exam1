package com.linocontreras.rockpaperscissors;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void updateGUI(){
        player_score.setText("Player: " + game.getPlayerScore());
        computer_score.setText("Computer: " + game.getComputerScore());
        computer.setText(game.getLastComputerChoice());

    }

    @Override
    public void onClick(View v){
        Toast message = Toast.makeText(getApplicationContext(), "This is weird", Toast.LENGTH_SHORT);
        if(v == rock){
            message = Toast.makeText(getApplicationContext(), game.play(0), Toast.LENGTH_SHORT);
        } else if(v == paper){
            message = Toast.makeText(getApplicationContext(), game.play(1), Toast.LENGTH_SHORT);
        } else if(v == scissors){
            message = Toast.makeText(getApplicationContext(), game.play(2), Toast.LENGTH_SHORT);
        }
        message.show();
        updateGUI();
    }


}
