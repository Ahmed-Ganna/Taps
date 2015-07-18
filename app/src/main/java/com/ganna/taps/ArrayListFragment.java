package com.ganna.taps;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ahmed on 10 / 6 / 2015
 */
public class ArrayListFragment extends ListFragment {
    // to decide which fragment to view
    private int mNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // if it the first time to open app num = bg_ag else its value given from past fragment
//        get this fragment's number
        if (getArguments() != null) {
            mNum = getArguments().getInt("num");
        } else {
            // if the app is first time open , will adapt the first array to the adapter and show you can make seperate fragment
            // for each tap
            mNum = 1;
        }
    }

    /**
     * Create a new instance of our fragment, providing "num"
     * as an argument - it determines which page to display
     */
    static ArrayListFragment createNewFragmentToDisplay(int num) {
        ArrayListFragment displayFragment = new ArrayListFragment();
        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        displayFragment.setArguments(args);
        return displayFragment;
    }

    /*called each time the fragment's activity is created - which is
    each time a new page is displayed*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, getMyListArray()));
    }

//    our list arrays to be used - one per page
    private String[] getMyListArray() {
        String[] returnArray = {"no lists"};
        switch (mNum) {
            case 0:
                returnArray = CountriesClass.countries_one;
                break;
            case 1:
                returnArray = CountriesClass.countries_two;
                break;
            case 2:
                returnArray = CountriesClass.countries_three;
                break;

        }
        return returnArray;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "List " + (mNum + 1) + " selected item: " + (position + 1),Toast.LENGTH_SHORT).show();
    }
}