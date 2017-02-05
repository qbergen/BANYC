package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        ImageView imageView = (ImageView) findViewById(R.id.youth_Logo);
        imageView.setAnimation(anim);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), NaviActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);

    }
}
