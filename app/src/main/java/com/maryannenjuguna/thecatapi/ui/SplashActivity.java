package com.maryannenjuguna.thecatapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.maryannenjuguna.thecatapi.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //calling main activity to load after loading screen
                startActivity(new Intent(SplashActivity.this,BreedsActivity.class));
                finish(); //finish loading screen activity
            }
            //call mainActivity after 1 seconds
        }, 1000);

    }
    }