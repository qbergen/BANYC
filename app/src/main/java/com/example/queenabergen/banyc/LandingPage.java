package com.example.queenabergen.banyc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class LandingPage extends AppCompatActivity {
    private ImageView drawerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        drawerIcon = (ImageView)findViewById(R.id.youth_Icon);

    }

}
