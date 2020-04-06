package com.ajith.covid_19;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("all")
    Call<JsonElement> getDataWorld();

    @GET("data.json")
    Call<JsonElement> getDataIndia();
}
