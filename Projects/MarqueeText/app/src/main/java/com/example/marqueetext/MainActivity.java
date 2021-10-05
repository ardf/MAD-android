package com.example.marqueetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMarquee = findViewById(R.id.tv_marquee);
        tvMarquee.setText("Hello World! This is a demo version of my Android mini project. Please give your feedback.");
    }

    public void startMarquee(View view) {
        tvMarquee.setSelected(true);
    }

    public void stopMarquee(View view) {
        tvMarquee.setSelected(false);
    }
}