package com.ajith.covid_19.countries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajith.covid_19.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    ArrayList<Country> countries;

    public CountryAdapter(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_countries, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        Country country = countries.get(position);

        holder.name.setText(country.getName());
        holder.cases.setText(country.getCases());
        holder.deaths.setText(country.getDeaths());
        holder.recover.setText(country.getRecovered());
        holder.today.setText(country.getToday());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView name, cases, deaths, recover, today;

        CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.country_name);
            cases = itemView.findViewById(R.id.country_cases);
            deaths = itemView.findViewById(R.id.country_deaths);
            recover = itemView.findViewById(R.id.country_recovered);
            today = itemView.findViewById(R.id.country_today);
        }
    }
}
