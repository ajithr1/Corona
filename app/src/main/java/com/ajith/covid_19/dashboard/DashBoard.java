package com.ajith.covid_19.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajith.covid_19.ApiInterface;
import com.ajith.covid_19.R;
import com.ajith.covid_19.api.ApiIndia;
import com.ajith.covid_19.api.ApiWorld;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends Fragment {

    private TextView t1, t2, t3, t4, t5, t6, date_i, date_w;

    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        t1 = view.findViewById(R.id.state_cases);
        t2 = view.findViewById(R.id.state_deaths);
        t3 = view.findViewById(R.id.state_recovered);
        t4 = view.findViewById(R.id.india_cases);
        t5 = view.findViewById(R.id.india_deaths);
        t6 = view.findViewById(R.id.india_recoverec);
        date_i = view.findViewById(R.id.date_india);
        date_w = view.findViewById(R.id.date_world);

        ApiInterface apiInterface = ApiWorld.getRetrofit().create(ApiInterface.class);
        ApiInterface apiInt = ApiIndia.getRetrofit().create(ApiInterface.class);

        Call<JsonElement> call = apiInterface.getDataWorld();
        Call<JsonElement> call1 = apiInt.getDataIndia();

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                JsonObject jsonObject = response.body().getAsJsonObject();

                t4.setText(jsonObject.get("cases").toString());
                t5.setText(jsonObject.get("deaths").toString());
                t6.setText(jsonObject.get("recovered").toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", Objects.requireNonNull(t.getMessage()));
            }
        });

        call1.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("statewise");
                JsonObject j = jsonArray.get(0).getAsJsonObject();

                t1.setText(j.get("confirmed").toString());
                t2.setText(j.get("deaths").toString());
                t3.setText(j.get("recovered").toString());
                date_i.setText(j.get("lastupdatedtime").toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", Objects.requireNonNull(t.getMessage()));
            }
        });

        return view;
    }
}
