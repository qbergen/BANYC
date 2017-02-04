package com.example.queenabergen.banyc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.queenabergen.banyc.retrofit.InformationCenter;

public class LandingPage extends AppCompatActivity{

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        recycler();
        InformationCenter.start(getApplicationContext(),rv);
    }

    private void recycler(){
        rv = (RecyclerView) findViewById(R.id.rview);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

}
