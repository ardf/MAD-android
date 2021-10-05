package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_username2,et_password2;
    Button btn_login2;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username2 = findViewById(R.id.et_username2);
        et_password2 = findViewById(R.id.et_password2);
        btn_login2 = findViewById(R.id.btn_login2);
        String regUsername = getIntent().getStringExtra("username");
        String regPassword = getIntent().getStringExtra("password");
        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username2.getText().toString();
                String password = et_password2.getText().toString();
                if(username.equals(regUsername) && password.equals(regPassword)) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intSuccess = new Intent(LoginActivity.this,SuccessActivity.class);
                    intSuccess.putExtra("username",username);
                    startActivity(intSuccess);
                    et_password2.setText("");
                    et_username2.setText("");
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    if(++counter==2){
                        Toast.makeText(LoginActivity.this,"Max Login Attempts reached",Toast.LENGTH_LONG).show();
                        btn_login2.setEnabled(false);
                    }
                }
            }
        });

    }
}