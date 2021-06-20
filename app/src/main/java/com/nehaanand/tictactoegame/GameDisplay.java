package com.nehaanand.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);
        Button playAgainBTN = findViewById(R.id.button_play_again);
        Button homeBTN = findViewById(R.id.button_home);
        TextView playerTurn = findViewById(R.id.player_display);
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        String[] playerNames = getIntent().getStringArrayExtra("Player_Names");
        if(playerNames != null){
            playerTurn.setText((playerNames[0]+"'s Turn"));
        }
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard3);
        ticTacToeBoard.setUpGame(playAgainBTN, homeBTN, playerTurn, playerNames);
    }

    public void playAgainButtonClick(View view){
        // do fancy stuff
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}