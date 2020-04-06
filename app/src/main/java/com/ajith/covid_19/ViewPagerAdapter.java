package com.ajith.covid_19;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        DashBoard dashBoard = new DashBoard();
        Bundle bundle = new Bundle();
        position = position + 1;

        bundle.putString("key", ""+position);
        dashBoard.setArguments(bundle);
        return dashBoard;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String temp = "";

        switch (position){

            case 0:
                temp = "DashBoard";
            break;
            case 1:
                temp = "States";
            break;
            case 2:
                temp = "India";
            break;
        }

        return temp;
    }
}
