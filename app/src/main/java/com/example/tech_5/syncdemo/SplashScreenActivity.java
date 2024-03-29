package com.example.tech_5.syncdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread mythread = new Thread(){
            @Override
            public void run() {
              try {
                  sleep(3000);
                  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                  startActivity(intent);
                  finish();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
            }
        };
        mythread.start();

    }
}
