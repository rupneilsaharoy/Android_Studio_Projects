package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestions = 0;
    TextView scoreTextView;

    public void chooseAnser(View view) {
        if (Integer.toString(locationofCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("Correct!");
            score++;
        } else {
            resultTextView.setText("Wrong :(");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));

    }



    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sumTextView = findViewById(R.id.sumTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);


        goButton = (Button)findViewById(R.id.goButton);

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationofCorrectAnswer = rand.nextInt(4);

        for (int i=0; i<4; i++) {
            if (i == locationofCorrectAnswer) {
                answers.add(a+b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
    }
}