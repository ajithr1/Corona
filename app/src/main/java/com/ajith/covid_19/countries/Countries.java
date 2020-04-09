package com.ajith.covid_19.countries;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajith.covid_19.ApiInterface;
import com.ajith.covid_19.R;
import com.ajith.covid_19.api.ApiIndia;
import com.ajith.covid_19.api.ApiWorld;
import com.ajith.covid_19.states.State;
import com.ajith.covid_19.states.StatesAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Countries extends Fragment {

    private RecyclerView recyclerView;

    public Countries() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_countries, container, false);
        recyclerView = view.findViewById(R.id.recycler_countries);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ArrayList<Country> countries = new ArrayList<>();
        ApiInterface apiInt = ApiWorld.getRetrofit().create(ApiInterface.class);
        Call<JsonElement> call = apiInt.getDataWorld();

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("reports");

                JsonObject jsonObject1 = jsonArray.get(0).getAsJsonObject();
                JsonArray jsonArray1 = jsonObject1.getAsJsonArray("table");
                JsonArray jsonArray2 = jsonArray1.get(0).getAsJsonArray();

                for (int i=1; i<jsonArray2.size(); i++) {
                    JsonObject j = jsonArray2.get(i).getAsJsonObject();

                    countries.add(new Country(j.get("Country").toString(),
                            j.get("TotalCases").toString(),
                            j.get("TotalDeaths").toString(),
                            j.get("TotalRecovered").toString(),
                            j.get("NewCases").toString()));

                    CountryAdapter countryAdapter = new CountryAdapter(countries);
                    recyclerView.setAdapter(countryAdapter);
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", "onFailure: -countries");
            }
        });

        return view;

    }
}
