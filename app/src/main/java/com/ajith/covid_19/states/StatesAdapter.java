package com.ajith.covid_19.states;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajith.covid_19.R;

import java.util.ArrayList;

public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.StatesViewHolder> {

    private ArrayList<State> stateArrayList;

    public StatesAdapter(ArrayList<State> stateArrayList) {
        this.stateArrayList = stateArrayList;
    }

    @NonNull
    @Override
    public StatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_states, parent, false);
        return new StatesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatesViewHolder holder, int position) {

        State state = stateArrayList.get(position);

        holder.name.setText(state.getName());
        holder.cases.setText(state.getCases());
        holder.deaths.setText(state.getDeaths());
        holder.recover.setText(state.getRecovered());
    }

    @Override
    public int getItemCount() {
        return stateArrayList.size();
    }

    static class StatesViewHolder extends RecyclerView.ViewHolder{

        TextView name, cases, deaths, recover;

        StatesViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.state_name);
            cases = itemView.findViewById(R.id.state_cases);
            deaths = itemView.findViewById(R.id.state_deaths);
            recover = itemView.findViewById(R.id.state_recovered);
        }
    }
}
