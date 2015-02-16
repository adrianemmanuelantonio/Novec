package com.group11.novec.adapter;

import com.group11.novec.FruitsPage1;
import com.group11.novec.FruitsPage2;
import com.group11.novec.FruitsPage3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new FruitsPage1();
        case 1:
            // Games fragment activity
            return new FruitsPage2();
        case 2:
            // Movies fragment activity
            return new FruitsPage3();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}