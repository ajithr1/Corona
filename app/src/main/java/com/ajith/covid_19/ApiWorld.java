package com.ajith.covid_19;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiWorld {

    /*accurate 1
    https://corona.lmao.ninja/all

     */
    private static final String BASE_URL = "https://corona.lmao.ninja/";
    /*accurate 2
    https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats
     */
    private static final String BASE_URL_1 = "https://api.covid19api.com/";
    /*accurate 3
     */
    private static final String BASE_URL_2 = "https://api.covid19api.com/";
    //accurate 4
    private static final String BASE_URL_3 = "https://api.covid19api.com/";
    private static Retrofit retrofit;


    static Retrofit getRetrofit() {
        if (retrofit == null){

            OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .build();

            //.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }

}
