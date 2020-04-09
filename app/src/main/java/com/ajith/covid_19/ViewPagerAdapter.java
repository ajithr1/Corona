package com.ajith.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ajith.covid_19.countries.Countries;
import com.ajith.covid_19.dashboard.DashBoard;
import com.ajith.covid_19.states.States;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new DashBoard();
        } else if (position == 1) {
            return new States();
        }
        return new Countries();
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
