package com.ajith.covid_19.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiWorld {

    /*accurate 1
    https://corona.lmao.ninja/all

     */
    private static final String BASE_URL_2 = "https://corona.lmao.ninja/";
    /*accurate 2
    https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats
     */
    private static final String BASE_URL_1 = "https://api.covid19api.com/";
    /*accurate 3
     */
    private static final String BASE_URL = "https://covid19-server.chrismichael.now.sh/api/v1/";
    private static Retrofit retrofit;


    public static Retrofit getRetrofit() {
        if (retrofit == null){

            OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }

}
