package com.example.queenabergen.banyc.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.queenabergen.banyc.recyclerview.RvAdapter;
import com.example.queenabergen.banyc.subjects.youthemploy.YouthEmployment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hyun on 1/30/17.
 */

public class InformationCenter {

    private static final String BASE_URL = "https://data.cityofnewyork.us/";
    private static List<YouthEmployment> info;
    private static RecyclerView rv;

    public static void start(final Context applicationContext, RecyclerView rv){
        InformationCenter.rv = rv;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InformationService infoService = retrofit.create(InformationService.class);

        Call<List<YouthEmployment>> callInfo = infoService.getPrograms();
        callInfo.enqueue(new Callback<List<YouthEmployment>>(){

            @Override
            public void onResponse(Call<List<YouthEmployment>> call, Response<List<YouthEmployment>> response) {
                info = response.body();
                initializeAdapter();
                //todo pass the info to the RecyclerView Adapter, below :
                // (Make sure to use, "rv" that's passed into this method)

                Toast.makeText(applicationContext,"Receiving Program Info", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<YouthEmployment>> call, Throwable t) {
                Toast.makeText(applicationContext,"Check your network", Toast.LENGTH_LONG).show();
            }
        });
    }

    private static void initializeAdapter(){
        RvAdapter adapter = new RvAdapter(info);
        rv.setAdapter(adapter);
    }
}
