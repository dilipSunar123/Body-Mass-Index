package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CardView maleCardView;
    private CardView femaleCardView;
    private TextView heightValue;
    private TextView weightValue;
    private TextView ageValue;
    private ImageView decHeight;
    private ImageView incHeight;
    private ImageView decWeight;
    private ImageView incWeight;
    private ImageView decAge;
    private ImageView incAge;
    private Button calculateBtn;

    private int height = 150;
    private int weight = 50;
    private int age = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleCardView = findViewById(R.id.male_card_view);
        femaleCardView = findViewById(R.id.female_card_view);
        heightValue = findViewById(R.id.height_value);
        heightValue.setText(String.valueOf(height));
        weightValue = findViewById(R.id.weight_value);
        weightValue.setText(String.valueOf(weight));
        ageValue = findViewById(R.id.age_value);
        ageValue.setText(String.valueOf(age));
        decHeight = findViewById(R.id.dec_height);
        incHeight = findViewById(R.id.inc_height);
        decWeight = findViewById(R.id.dec_weight);
        incWeight = findViewById(R.id.inc_weight);
        decAge = findViewById(R.id.dec_age);
        incAge = findViewById(R.id.inc_age);
        calculateBtn = findViewById(R.id.calc_btn);

        maleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // clicking on male card changes its color to pink and female's color to default
                maleCardView.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
                femaleCardView.setCardBackgroundColor(getResources().getColor(R.color.cardColor));
            }
        });

        femaleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // clicking on female card changes its color to pink and male's color to default
                femaleCardView.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
                maleCardView.setCardBackgroundColor(getResources().getColor(R.color.cardColor));
            }
        });

        incHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementHeight();
            }
        });
        decHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementHeight();
            }
        });
        incWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementWeight();
            }
        });
        decWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementWeight();
            }
        });
        incAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementAge();
            }
        });
        decAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementAge();
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                intent.putExtra("age", age);

                startActivity(intent);
            }
        });
    }

    private void incrementHeight() {
        if (height >= 251) {
            Toast.makeText(this, "Height cannot be more than " + height, Toast.LENGTH_SHORT).show();
            return;
        }
        height++;
        heightValue.setText(String.valueOf(height));
    }

    private void decrementHeight() {
        if (height <= 90) {
            Toast.makeText(this, "Height cannot be less than " + height, Toast.LENGTH_SHORT).show();
            return;
        }
        height--;
        heightValue.setText(String.valueOf(height));
    }

    private void incrementWeight() {
        if (weight >= 100) {
            Toast.makeText(this, "Weight cannot be more than " + weight, Toast.LENGTH_SHORT).show();
            return;
        }
        weight++;
        weightValue.setText(String.valueOf(weight));
    }

    private void decrementWeight() {
        if (weight <= 25) {
            Toast.makeText(this, "Weight cannot be less than " + weight, Toast.LENGTH_SHORT).show();
            return;
        }
        weight--;
        weightValue.setText(String.valueOf(weight));
    }

    private void incrementAge() {
        if (age >= 100) {
            Toast.makeText(this, "Age cannot be more than " + age, Toast.LENGTH_SHORT).show();
            return;
        }
        age++;
        ageValue.setText(String.valueOf(age));
    }

    private void decrementAge() {
        if (age <= 20) {
            Toast.makeText(this, "Age cannot be less than " + age, Toast.LENGTH_SHORT).show();
            return;
        }
        age--;
        ageValue.setText(String.valueOf(age));
    }
}