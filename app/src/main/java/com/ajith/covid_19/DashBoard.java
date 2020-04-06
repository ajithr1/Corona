package com.ajith.covid_19;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends Fragment {

    private TextView t1, t2, t3, t4, t5, t6;

    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        t1 = view.findViewById(R.id.world_cases);
        t2 = view.findViewById(R.id.world_deaths);
        t3 = view.findViewById(R.id.world_recovered);
        t4 = view.findViewById(R.id.india_cases);
        t5 = view.findViewById(R.id.india_deaths);
        t6 = view.findViewById(R.id.india_recoverec);

        ApiInterface apiInterface = ApiWorld.getRetrofit().create(ApiInterface.class);
        ApiInterface apiInt = ApiIndia.getRetrofit().create(ApiInterface.class);

        Call<JsonElement> call = apiInterface.getDataWorld();
        Call<JsonElement> call1 = apiInt.getDataIndia();

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.d("ajju", response.body().toString());

                JsonObject jsonObject = response.body().getAsJsonObject();

                t1.setText(jsonObject.get("cases").toString());
                t2.setText(jsonObject.get("deaths").toString());
                t3.setText(jsonObject.get("recovered").toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", Objects.requireNonNull(t.getMessage()));
            }
        });

        call1.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                t4.setText(response.body().toString());
                Log.d("ajju", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", Objects.requireNonNull(t.getMessage()));
            }
        });

        return view;
    }
}
