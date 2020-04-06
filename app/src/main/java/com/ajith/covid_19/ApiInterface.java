package com.ajith.covid_19;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("data.json")
    Call<JsonObject> getData();
}
