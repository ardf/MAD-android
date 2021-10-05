package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text_counter;
    Button button_start,button_stop;
    Handler myHandler = new Handler();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_counter = findViewById(R.id.text_counter);
        button_start = findViewById(R.id.button_start);
        button_stop = findViewById(R.id.button_stop);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.postDelayed(threadCounter,1000);
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.removeCallbacks(threadCounter);
            }
        });
    }
    public Runnable threadCounter = new Runnable() {
        @Override
        public void run() {
            text_counter.setText(""+count);
            count++;
            myHandler.postDelayed(this,1000);
        }
    };
}