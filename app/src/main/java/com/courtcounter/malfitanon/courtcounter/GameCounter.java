package com.courtcounter.malfitanon.courtcounter;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameCounter extends AppCompatActivity {

    private String name1;
    private String name2;

    private EditText team1;
    private EditText team2;

    private TextView score;
    private TextView score2;
    
    private AlertDialog gameOverAlert;
    private MediaPlayer sound;

    private int s = 0;
    private int s2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);

        score = (TextView)findViewById(R.id.points);
        score.setText(String.valueOf(s));

        score2 = (TextView)findViewById(R.id.points2);
        score2.setText(String.valueOf(s2));

        gameOverAlert= new AlertDialog.Builder(GameCounter.this).create();

        gameOverAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        team1 = (EditText)findViewById(R.id.name1);

        team2 = (EditText)findViewById(R.id.name2);
    }


    public void addPoints(View view) {
        s++;
        score.setText(String.valueOf(s));
        sound = MediaPlayer.create(this , R.raw.bomb);
        sound.start();

    }

    public void addPoints2(View view) {
        s2++;
        score2.setText(String.valueOf(s2));
        sound = MediaPlayer.create(this , R.raw.hiwelcometo);
        sound.start();
    }

    public void minusPoints(View view) {
        s--;
        score.setText(String.valueOf(s));
        sound = MediaPlayer.create(this , R.raw.bomb);
        sound.start();

    }

    public void minusPoints2(View view) {
        s2--;
        score2.setText(String.valueOf(s2));
        sound = MediaPlayer.create(this , R.raw.hiwelcometo);
        sound.start();
    }

    public void reset(View view){


        gameOverAlert.setTitle("Alert Title");

        if (s > s2) {
            name1 = team1.getText().toString();
            gameOverAlert.setMessage( name1 + " wins");
        }else{
            name2 = team2.getText().toString();
            gameOverAlert.setMessage( name2 + " wins");
        }
        if (s2 == s) {
            gameOverAlert.setMessage("Its a Tie");
        }
        gameOverAlert.show();

        s = 0;
        s2 = 0;

        score.setText(String.valueOf(s));
        score2.setText(String.valueOf(s2));
    }


}



