package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText heightText,weightText,bmiText;
    Button calcBtn;
    TextView statusText,bmiLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightText = findViewById(R.id.heightText);
        weightText = findViewById(R.id.weightText);
        bmiText = findViewById(R.id.bmiText);
        calcBtn = findViewById(R.id.btnCalculate);
        bmiLabel = findViewById(R.id.bmiLabel);
        statusText = findViewById(R.id.bmiStatusText);

        bmiLabel.setVisibility(View.INVISIBLE);
        bmiText.setVisibility(View.INVISIBLE);
        statusText.setVisibility(View.INVISIBLE);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
    private void calculateBMI(){
        float height = Float.valueOf(heightText.getText().toString());
        float weight = Float.valueOf(weightText.getText().toString());
        float bmi = weight / (height*height);

        bmiLabel.setVisibility(View.VISIBLE);
        bmiText.setVisibility(View.VISIBLE);
        statusText.setVisibility(View.VISIBLE);
        bmiText.setText(String.valueOf(bmi));

        statusCalc(bmi);
    }
    private void statusCalc(float bmi){
        String text;
        int color;
        if(bmi<=0){
            text = "Invalid";
            color = R.color.design_default_color_error;
        }
        else if (bmi<=15){
            text = "Very Severely Underweight";
            color = R.color.red;
        }
        else if(bmi<=16){
            text = "Severely underweight";
            color = R.color.orange;
        }
        else if(bmi<=18.5){
            text = "Underweight";
            color = R.color.yellow;
        }
        else if(bmi<=25){
            text = "Normal";
            color = R.color.green;
        }
        else if(bmi<=30){
            text = "Overweight";
            color = R.color.yellow;
        }
        else if(bmi<=35){
            text = "Moderately Obese";
            color = R.color.orange;
        }
        else if(bmi<=40){
            text = "Severely Obese";
            color = R.color.red;

        }
        else{
            text= " Very Severely Obese";
            color = R.color.red;
        }

        statusText.setText(text);
        statusText.setBackgroundColor(getResources().getColor(color));
    }

}