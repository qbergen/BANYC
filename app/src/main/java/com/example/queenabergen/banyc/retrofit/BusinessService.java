package com.example.queenabergen.banyc.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 2/4/17.
 */

public interface BusinessService {

    @GET("resource/mrxb-9w9v.json")
    Call<List<BusinessPrograms>> getBusinessPrograms();
}
