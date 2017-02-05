package com.example.queenabergen.banyc.subjects.business;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.queenabergen.banyc.R;
import com.example.queenabergen.banyc.retrofit.BusinessCenter;

/**
 * Created by Hyun on 2/4/17.
 */

public class BusinessPage extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        recycler();
        BusinessCenter.start(rv);
    }

    private void recycler() {
        rv = (RecyclerView) findViewById(R.id.rview);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
