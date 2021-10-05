package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SuccessActivity extends AppCompatActivity {
    TextView tv_success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        tv_success = findViewById(R.id.tv_success);
        String user = getIntent().getStringExtra("username");
        tv_success.setText("Welcome "+user);
    }
}