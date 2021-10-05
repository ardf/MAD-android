package com.example.wallpaperchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btnWallpaper;
    Timer myTimer;
    WallpaperManager myWpm;
    Drawable myDrawable;
    ImageView currentWallpaper;
    int nextPaper = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTimer = new Timer();
        myWpm = WallpaperManager.getInstance(this);
        btnWallpaper = findViewById(R.id.btnWallpaper);
        btnWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeWallpaper();
            }
        });
    }
    private void changeWallpaper(){
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentWallpaper = (ImageView) findViewById(R.id.currentWallpaper);
                if(nextPaper==1){
                    myDrawable = getResources().getDrawable(R.drawable.one);
                    try {
                        currentWallpaper.setImageResource(R.drawable.one);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    nextPaper=2;
                }
                else if(nextPaper==2){
                    myDrawable = getResources().getDrawable(R.drawable.two);
                    try {
                        currentWallpaper.setImageResource(R.drawable.two);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    nextPaper=3;
                }
                else if(nextPaper==3){
                    myDrawable = getResources().getDrawable(R.drawable.three);
                    try {
                        currentWallpaper.setImageResource(R.drawable.three);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    nextPaper=1;
                }
                Bitmap wallpaper = ((BitmapDrawable)myDrawable).getBitmap();
                try {
                    myWpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },5000,10000);
    }
}