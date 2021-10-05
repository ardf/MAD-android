package com.example.text_to_speech;

import androidx.appcompat.app.AppCompatActivity;
import static android.speech.tts.TextToSpeech.*;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.speakButton);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == SUCCESS)
                    tts.setLanguage(Locale.UK);
                else{
                    Log.e("TTS","Initialization failed");
                    btn.setEnabled(false);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertText();
            }
        });

    }
    private void convertText(){
        String myString = editText.getText().toString();
        tts.speak(myString,QUEUE_FLUSH,null,null);
    }
}