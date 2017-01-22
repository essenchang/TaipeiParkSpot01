package com.fishbowl.taipeiparkspot;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by essenchang on 2017/1/21.
 */

public interface ParkSpotsApi {
    // http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=bf073841-c734-49bf-a97f-3757a6013812
    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=bf073841-c734-49bf-a97f-3757a6013812")
    Call<ParkSpotResultDTO> contributorsBySimpleGetCall();
}
