package com.example.queenabergen.banyc.retrofit;

import com.example.queenabergen.banyc.subjects.business.BusinessInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 2/5/17.
 * https://data.cityofnewyork.us/
 */

public interface BusinessService {

    @GET("resource/dzsg-fjem.json")
    Call<List<BusinessInfo>> getPrograms();
}
