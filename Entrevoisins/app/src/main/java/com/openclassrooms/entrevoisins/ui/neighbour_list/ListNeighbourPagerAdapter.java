package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position item position
     * @return fragment
     */
    @Override
    public Fragment getItem(int position) {
        return NeighbourFragment.newInstance(position);
    }

    /**
     * get the number of pages
     * @return number of page
     */
    @Override
    public int getCount() {
        return 2;
    }

}