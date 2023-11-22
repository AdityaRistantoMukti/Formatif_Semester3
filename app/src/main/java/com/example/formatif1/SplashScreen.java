package com.example.formatif1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent login = new Intent(SplashScreen.this, LoginActivity.class);
        Handler handler = new Handler();
        Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                startActivity(login);
                finish();
            }
        };
                handler.postDelayed(runnable, 2000);
    }
}