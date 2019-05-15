package com.badoualy.stepperindicator.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

class PagerAdapter extends FragmentPagerAdapter {
    final ViewPager mpager ;
    public PagerAdapter(FragmentManager fm, ViewPager pager) {
        super(fm);
        mpager = pager;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1, position == getCount() - 1, mpager, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}