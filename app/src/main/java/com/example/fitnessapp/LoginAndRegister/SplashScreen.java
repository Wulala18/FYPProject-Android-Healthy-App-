package com.example.fitnessapp.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fitnessapp.R;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    Runnable runn;
    ImageView img;
    LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.worksplash);
        img.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        handler = new Handler();
        handler.postDelayed(() -> {
            Intent dsp = new Intent(SplashScreen.this,Login.class);
            startActivity(dsp);
            finish();
        },4000);
    }
}
