package com.ajith.covid_19;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends Fragment {

    private TextView textView;

    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        textView = view.findViewById(R.id.world_cases);

        ApiInterface apiInterface = ApiClass.getRetrofit().create(ApiInterface.class);

        Call<JsonElement> call = apiInterface.getData();

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.d("ajju", response.body().toString());
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });

        return view;
    }
}
