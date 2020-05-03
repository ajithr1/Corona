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

    private ArrayList<Country> countries;

    CountryAdapter(ArrayList<Country> countries) {
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

        holder.name.setText(removeQuotes(country.getName()));
        holder.cases.setText(removeQuotes(country.getCases()));
        holder.deaths.setText(removeQuotes(country.getDeaths()));
        holder.recover.setText(removeQuotes(country.getRecovered()));
        holder.today_cases.setText(removeQuotes(country.getToday_cases()));
        holder.today_deaths.setText(removeQuotes(country.getToday_deaths()));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView name, cases, deaths, recover, today_cases, today_deaths;

        CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.c_name);
            cases = itemView.findViewById(R.id.w_cases);
            deaths = itemView.findViewById(R.id.w_deaths);
            recover = itemView.findViewById(R.id.w_recoverec);
            today_cases = itemView.findViewById(R.id.w_t_c);
            today_deaths = itemView.findViewById(R.id.w_t_d);
        }
    }

    private String removeQuotes(String string){

        String res = string.replace("\"", "");
        return res;
    }
}
