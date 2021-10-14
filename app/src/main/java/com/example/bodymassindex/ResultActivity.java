package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView score;
    private TextView normalOrNot;
    private CardView resultCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = findViewById(R.id.score);
        normalOrNot = findViewById(R.id.score_normalOrNot);
        resultCard = findViewById(R.id.resultCard);

        Intent intent = getIntent();
        int height = intent.getIntExtra("height", 1);
        int weight = intent.getIntExtra("weight", 1);
        int age = intent.getIntExtra("age", 1);

        float height_float = height + .0f;
        // height must be in meter^2
        float height_meter = (float) (height_float/100) * (height_float/100);

        if (weight / height_meter < 18.5) {
            score.setText("Your BMI score is: " + weight / height_meter);
            resultCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            normalOrNot.setText("UNDER-WEIGHT");
        } else if (weight / height_meter >= 18.5 && weight / height_meter <= 24.9) {
            score.setText("Your BMI score is: " + weight / height_meter);
            resultCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            normalOrNot.setText("NORMAL");
        } else if (weight / height_meter >= 25 && weight / height_meter <= 29.9) {
            score.setText("Your BMI score is: " + weight / height_meter);
            resultCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            normalOrNot.setText("OVERWEIGHT");
        } else if (weight / height_meter >= 30.0) {
            score.setText("Your BMI score is: " + weight / height_meter);
            resultCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            normalOrNot.setText("OBESE");
        }

    }
}