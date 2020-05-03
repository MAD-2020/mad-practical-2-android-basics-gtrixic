package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Score;
    int score = 0;
    private static final String TAG = "Whack-A-Mole!";

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Score = (TextView) findViewById(R.id.Score);

        Score.setText("" + score);


    }


    public void setNewMole() {
        Button[] buttons = {ButtonLeft, ButtonMiddle, ButtonRight};
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button rb = buttons[randomLocation];
        for (Button b : buttons) {
            if (b == rb) {
                b.setText("*");
            } else {
                b.setText("O");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Starting GUI");
        setNewMole();
    }

    public void OnClickButton(View v) {
        Button b = (Button) v;
        if (Mole(b) == true) {
            score++;
            Score.setText("" + score);
            text(b);
            Log.v(TAG, "Hit, score added!");
        } else {
            if (score > 0) {
                score--;
                Score.setText("" + score);
                text(b);
                Log.v(TAG, "Missed, score deducted!");
            }
            else
            {
                score = 0;
                Score.setText("" + score);
                text(b);
                Log.v(TAG, "Missed, score deducted!");
            }
        }

        setNewMole();
    }


    public boolean Mole(Button b) {
        if (b.getText() == "*") {
            return true;
        } else {
            return false;
        }
    }

    public void text(Button b)
    {
        if(b == ButtonLeft)
        {
            Log.v(TAG, "Button Left Clicked!");
        }
        if(b == ButtonMiddle)
        {
            Log.v(TAG, "Button Middle Clicked!");
        }
        if (b == ButtonRight)
        {
            Log.v(TAG, "Button Right Clicked");
        }
    }
}
