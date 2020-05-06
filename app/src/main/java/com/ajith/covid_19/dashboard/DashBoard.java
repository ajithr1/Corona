package com.ajith.covid_19.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ajith.covid_19.ApiInterface;
import com.ajith.covid_19.R;
import com.ajith.covid_19.api.ApiIndia;
import com.ajith.covid_19.api.ApiWorld;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends Fragment {

    private TextView t1, t2, t3, t4, t5, t6, date_i, date_w,s1, s2, s3, s4, s5;
    private ProgressBar p1, p2;

    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        t1 = view.findViewById(R.id.i_cases);
        t2 = view.findViewById(R.id.i_deaths);
        t3 = view.findViewById(R.id.i_recovered);
        t4 = view.findViewById(R.id.w_cases);
        t5 = view.findViewById(R.id.w_deaths);
        t6 = view.findViewById(R.id.w_recoverec);
        date_i = view.findViewById(R.id.date_world);
        date_w = view.findViewById(R.id.date_world);
        s1 = view.findViewById(R.id.i_t_c);
        s2 = view.findViewById(R.id.i_t_d);
        s3 = view.findViewById(R.id.i_t_r);
        s4 = view.findViewById(R.id.w_t_c);
        s5 = view.findViewById(R.id.w_t_d);

        p2 = view.findViewById(R.id.progress_world);
        p1 = view.findViewById(R.id.progress_india);

        p1.setVisibility(View.VISIBLE);
        p2.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiWorld.getRetrofit().create(ApiInterface.class);
        ApiInterface apiInt = ApiIndia.getRetrofit().create(ApiInterface.class);

        Call<JsonElement> callWorld = apiInterface.getDataWorld();
        Call<JsonElement> callIndia = apiInt.getDataIndia();

        callIndia.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("statewise");
                JsonObject j = jsonArray.get(0).getAsJsonObject();

                t1.setText(removeQuotes(j.get("confirmed").toString()));
                t2.setText(removeQuotes(j.get("deaths").toString()));
                t3.setText(removeQuotes(j.get("recovered").toString()));
                date_i.setText(removeQuotes(j.get("lastupdatedtime").toString()));

                s1.setText(removeQuotes(j.get("deltaconfirmed").toString()));
                s2.setText(removeQuotes(j.get("deltadeaths").toString()));
                s3.setText(removeQuotes(j.get("deltarecovered").toString()));

                p1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", "India fail- "+Objects.requireNonNull(t.getMessage()));
                p1.setVisibility(View.INVISIBLE);
            }
        });

        callWorld.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("reports");

                JsonObject jsonObject1 = jsonArray.get(0).getAsJsonObject();
                JsonArray jsonArray1 = jsonObject1.getAsJsonArray("table");
                JsonArray jsonArray2 = jsonArray1.get(0).getAsJsonArray();
                JsonObject jsonObject2 = jsonArray2.get(0).getAsJsonObject();


                t4.setText(removeQuotes(jsonObject2.get("TotalCases").toString()));
                t5.setText(removeQuotes(jsonObject2.get("TotalDeaths").toString()));
                t6.setText(removeQuotes(jsonObject2.get("TotalRecovered").toString()));

                s4.setText(removeQuotes(jsonObject2.get("NewCases").toString()));
                s5.setText(removeQuotes(jsonObject2.get("NewDeaths").toString()));
                p2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", "World fail - "+Objects.requireNonNull(t.getMessage()));
                p2.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }

    private String removeQuotes(String string){

        String res = string.replace("\"", "");
        return res;
    }
}
