package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText et_username1,et_password1;
    Button btn_signup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username1 = findViewById(R.id.et_username1);
        et_password1 = findViewById(R.id.et_password1);
        btn_signup1 = findViewById(R.id.btn_signup1);
        btn_signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username1.getText().toString();
                String password = et_password1.getText().toString();
                if(validate(password)) {
                    Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_LONG).show();
                    Intent intLogin = new Intent(MainActivity.this,LoginActivity.class);
                    intLogin.putExtra("password",password);
                    intLogin.putExtra("username",username);
                    startActivity(intLogin);
                    et_password1.setText("");
                    et_username1.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Sign Up Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validate(String password) {
        Pattern ptrn;
        Matcher match;
        String pwdptrn = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,}$";
        ptrn = Pattern.compile(pwdptrn);
        match = ptrn.matcher(password);
        return match.matches();
    }
}