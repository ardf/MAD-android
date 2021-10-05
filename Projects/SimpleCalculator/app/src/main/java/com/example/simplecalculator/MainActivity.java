package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText num1, num2;
    public static final int LENGTH_LONG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        num1 = findViewById(R.id.editTextNumberDecimal);
        num2 = findViewById(R.id.editTextNumberDecimal2);
    }
    public boolean check(){

        if(TextUtils.isEmpty(num1.getText().toString()) || TextUtils.isEmpty(num2.getText().toString())){
            Toast.makeText(getApplicationContext(),"Enter both numbers to proceed",Toast.LENGTH_LONG);
            return false;
        }
        return true;
    }

    public void addMethod(View view) {
        if(!check())
            return;
        Float n1 = Float.parseFloat(num1.getText().toString());
        Float n2 = Float.parseFloat(num2.getText().toString());
        Float res = n1 + n2;
        result.setText(""+res);
    }

    public void mulMethod(View view) {
        if(!check())
            return;
        Float n1 = Float.parseFloat(num1.getText().toString());
        Float n2 = Float.parseFloat(num2.getText().toString());
        Float res = n1 * n2;
        result.setText(""+res);
    }

    public void subMethod(View view) {
        if(!check())
            return;
        Float n1 = Float.parseFloat(num1.getText().toString());
        Float n2 = Float.parseFloat(num2.getText().toString());
        Float res = n1 - n2;
        result.setText(""+res);
    }

    public void divMethod(View view) {
        if(!check())
            return;
        Float n1 = Float.parseFloat(num1.getText().toString());
        Float n2 = Float.parseFloat(num2.getText().toString());
        if(n2 != 0) {
            Float res = n1 / n2;
            result.setText(""+res);
        }
        else{
            result.setText("");
            Toast.makeText(getApplicationContext(),"cannot divide by 0",Toast.LENGTH_LONG).show();
        }
    }
}