package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000); // Set thời gian 5 giây hiển thị màn hình SplashScreen
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, GetStartedActivity.class);
                    finish();
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}