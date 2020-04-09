package com.ajith.covid_19.states;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ajith.covid_19.ApiInterface;
import com.ajith.covid_19.R;
import com.ajith.covid_19.api.ApiIndia;
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
public class States extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public States() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_states, container, false);
        recyclerView = view.findViewById(R.id.recycler_states);
        progressBar = view.findViewById(R.id.progressBar2);

        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ArrayList<State> arrayList = new ArrayList<>();

        //Grepping data from server
        ApiInterface apiInt = ApiIndia.getRetrofit().create(ApiInterface.class);
        Call<JsonElement> call = apiInt.getDataIndia();

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                assert response.body() != null;
                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("statewise");

                //get data outside the enqueue

                Log.d("ajju", "l "+jsonArray.size());

                for (int i=1; i<jsonArray.size(); i++) {
                    JsonObject json = jsonArray.get(i).getAsJsonObject();
                    arrayList.add(new State(json.get("state").toString(), json.get("confirmed").toString(),
                            json.get("deaths").toString(), json.get("recovered").toString(),
                            json.get("deltaconfirmed").toString()));
                }

                StatesAdapter statesAdapter = new StatesAdapter(arrayList);
                recyclerView.setAdapter(statesAdapter);

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("ajju", "onFailure: States");
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }
}
