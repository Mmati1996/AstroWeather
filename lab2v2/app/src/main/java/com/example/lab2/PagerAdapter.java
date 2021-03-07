package com.example.lab2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.mNoOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;

            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            default:
                return null;

        }
    }



    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
