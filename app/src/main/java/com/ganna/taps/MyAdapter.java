package com.ganna.taps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Ahmed on 10 / 6 / 2015
 */
public class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    //    returns the number of views available
    @Override
    public int getCount() {
        return MainActivity.NUMBER_OF_LISTS;
    }

    // when swiping returns a fragment with the object identified by position
    @Override
    public Fragment getItem(int position) {
        // return fragment to display
        // pass position to decide which list to display review the method
        // it is static could be accessed by the class it self
        return ArrayListFragment.createNewFragmentToDisplay(position);
    }

    /*gets the title describing specified page
    and passes it to the PagerTitleStrip in
    activity_main.xml - displays either top or
    bottom of screen*/
    @Override
    public CharSequence getPageTitle(int position) {
        return "Ahmed's List " + (position + 1);
    }
}
