package com.ajith.covid_19;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ajith.covid_19.countries.Countries;
import com.ajith.covid_19.dashboard.DashBoard;
import com.ajith.covid_19.states.States;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Context context;

    ViewPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);

        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {

            if (position == 0) {
                return new DashBoard();
            } else if (position == 1) {
                return new States();
            }
            return new Countries();

        }else {
            return new NoConnection();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String temp = "";

        switch (position) {

            case 0:
                temp = "DashBoard";
                break;
            case 1:
                temp = "States";
                break;
            case 2:
                temp = "Countries";
                break;
        }

        return temp;
    }
}
