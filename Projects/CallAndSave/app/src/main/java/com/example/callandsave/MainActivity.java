package com.example.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_phoneNum;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_phoneNum = findViewById(R.id.et_phoneNum);
    }

    public void editPhoneNum(View view) {
        Button btn = (Button) view;
        String btnDigit = btn.getText().toString();
        String phoneNum = et_phoneNum.getText().toString();
            et_phoneNum.setText(phoneNum+btnDigit);


    }

    public void deleteLastDigit(View view) {
        String phoneNum = et_phoneNum.getText().toString();
        if(phoneNum.length()>0) {
            et_phoneNum.setText(phoneNum.substring(0,phoneNum.length()-1));
        }
    }

    public void clearPhoneNum(View view) {
        et_phoneNum.setText("");
    }

    public void savePhoneNum(View view) {
        Intent save = new Intent(Intent.ACTION_INSERT);
        String phoneNum = et_phoneNum.getText().toString();
        save.setType(ContactsContract.Contacts.CONTENT_TYPE);
        save.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNum);
        startActivity(save);
    }

    public void callPhoneNum(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        String phoneNum = et_phoneNum.getText().toString();
        call.setData(Uri.parse("tel:"+phoneNum));
        startActivity(call);
    }
}