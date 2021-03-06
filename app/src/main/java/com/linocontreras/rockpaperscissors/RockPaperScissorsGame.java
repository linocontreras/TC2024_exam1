package com.linocontreras.rockpaperscissors;

import java.util.Random;

public class RockPaperScissorsGame {
    private int playerScore = 0;
    private int computerScore = 0;
    private Random random;
    private int computer = 0;

    public RockPaperScissorsGame(){
        random = new Random();
    }

    public int play(int c){
        computer = random.nextInt(3);
        if(computer == c){
            return 0;
        } else if(computer == c - 1 || computer == c + 2){
            playerScore++;
            return 1;
        } else{
            computerScore++;
            return 2;
        }

    }

    public void reset(){
        playerScore = 0;
        computerScore = 0;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public int getComputerScore(){
        return computerScore;
    }

    public String getLastComputerChoice(){
        switch (computer){
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
        }
        return "";
    }
}
