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

    StatesAdapter(ArrayList<State> stateArrayList) {
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

        holder.name.setText(removeQuotes(state.getName()));
        holder.cases.setText(removeQuotes(state.getCases()));
        holder.deaths.setText(removeQuotes(state.getDeaths()));
        holder.recover.setText(removeQuotes(state.getRecovered()));
        holder.today_c.setText(removeQuotes(state.getToday_cases()));
        holder.today_d.setText(removeQuotes(state.getToday_deaths()));
        holder.today_r.setText(removeQuotes(state.getToday_recovered()));
    }

    @Override
    public int getItemCount() {
        return stateArrayList.size();
    }

    static class StatesViewHolder extends RecyclerView.ViewHolder{

        TextView name, cases, deaths, recover, today_c, today_d, today_r;

        StatesViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.s_name);
            cases = itemView.findViewById(R.id.i_cases);
            deaths = itemView.findViewById(R.id.i_deaths);
            recover = itemView.findViewById(R.id.i_recovered);
            today_c = itemView.findViewById(R.id.i_t_c);
            today_d = itemView.findViewById(R.id.i_t_d);
            today_r = itemView.findViewById(R.id.i_t_r);
        }
    }

    private String removeQuotes(String string){

        String res = string.replace("\"", "");
        return res;
    }
}
