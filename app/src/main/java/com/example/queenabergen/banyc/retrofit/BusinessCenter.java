package com.example.queenabergen.banyc.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.queenabergen.banyc.recyclerview.BusinessAdapter;
import com.example.queenabergen.banyc.subjects.business.BusinessInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hyun on 2/4/17.
 */

public class BusinessCenter {

    private static final String BASE_URL = "https://data.cityofnewyork.us/";
    private static List<BusinessInfo> info;
    private static List<BusinessInfo> data;
    private static RecyclerView rv;

    public static void start(final Context applicationContext, RecyclerView rv) {
        BusinessCenter.rv = rv;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BusinessService infoService = retrofit.create(BusinessService.class);

        Call<List<BusinessInfo>> callInfo = infoService.getPrograms();
        callInfo.enqueue(new Callback<List<BusinessInfo>>() {

            @Override
            public void onResponse(Call<List<BusinessInfo>> call, Response<List<BusinessInfo>> response) {
                info = response.body();
                initializeAdapter();

                Toast.makeText(applicationContext, "Receiving Program Info", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<BusinessInfo>> call, Throwable t) {
                Toast.makeText(applicationContext, "Check your network", Toast.LENGTH_LONG).show();
            }
        });
    }

    private static void initializeAdapter() {
        BusinessAdapter adapter = new BusinessAdapter(info);
        rv.setAdapter(adapter);
    }
}
