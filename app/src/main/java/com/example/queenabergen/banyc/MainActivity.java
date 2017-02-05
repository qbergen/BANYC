package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.queenabergen.banyc.facebook.FacebookLoginActivity;
import com.example.queenabergen.banyc.google.GoogleLoginActivity;
import com.facebook.CallbackManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button facebookBtn;
    private ImageView googleBtn;
    private CallbackManager callbackManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        callbackManager = CallbackManager.Factory.create();
        initViews();
    }

    private void initViews() {
        facebookBtn = (Button) findViewById(R.id.login_button);
        facebookBtn.setOnClickListener(this);
        googleBtn = (ImageView) findViewById(R.id.google_btn);
        googleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_button:
                Intent fbIntent = new Intent(getApplicationContext(), FacebookLoginActivity.class);
                startActivity(fbIntent);
                break;
            case R.id.google_btn:
                Intent googleIntent = new Intent(getApplicationContext(), GoogleLoginActivity.class);
                startActivity(googleIntent);
                break;
        }
    }
}