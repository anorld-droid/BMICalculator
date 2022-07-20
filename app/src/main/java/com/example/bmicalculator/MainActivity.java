package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonListener();
    }

    @SuppressLint("SetTextI18n")
    public void buttonListener(){
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            final EditText heightText = findViewById(R.id.heightinput);
            String heightStr =  heightText.getText().toString();
            double height = Double.parseDouble(heightStr);
            final EditText weightText = findViewById(R.id.weightinput);
            String weightStr =  weightText.getText().toString();
            double weight = Double.parseDouble(weightStr);
            double BMI = (weight)/(height*height);
            final EditText BMIResult = findViewById(R.id.BMIResult);
            DecimalFormat df = new DecimalFormat("#.#");
            double BMI_trimmed = Double.parseDouble(df.format(BMI));
            BMIResult.setText(Double.toString(BMI_trimmed));
            String BMI_Cat;
            if (BMI <= 15)
            BMI_Cat = "Very severely underweight.";
            else if (BMI <= 16)
            BMI_Cat = "Severely underweight.";
            else if (BMI <= 18.5)
            BMI_Cat = "Underweight.";
            else if (BMI <= 25)
            BMI_Cat = "Normal.";
            else if (BMI <= 30)
            BMI_Cat = "Overweight.";
            else if (BMI <= 35)
            BMI_Cat = "Obese Class 1 - Moderately Obese.";
            else if (BMI <= 40)
            BMI_Cat = "Obese Class 2 - Severely Obese.";
            else
            BMI_Cat = "Obese Class 1 - Very severely Obese.";
            final TextView BMICategory = findViewById(R.id.BMICategory);
            BMICategory.setText(BMI_Cat);
        });

    }

}