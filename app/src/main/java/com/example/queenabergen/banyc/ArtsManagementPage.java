package com.example.queenabergen.banyc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ArtsManagementPage extends AppCompatActivity  {
public LinearLayoutManager linearLayoutManager;
    public ArtsAdapter artsAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artslandingpage);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.artsPageRecView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        artsAdapter = new ArtsAdapter();
        recyclerView.setAdapter(artsAdapter);
    }


}
