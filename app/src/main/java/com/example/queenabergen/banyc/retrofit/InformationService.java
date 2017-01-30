package com.example.queenabergen.banyc.retrofit;

import com.example.queenabergen.banyc.subjects.youthemploy.YouthEmployment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 1/30/17.
 */

public interface InformationService {

    @GET("resource/mrxb-9w9v.json")
    Call<List<YouthEmployment>> getPrograms();
}
