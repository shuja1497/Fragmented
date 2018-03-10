package com.shuja1497.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by shuja1497 on 3/9/18.
 */

public class ClubListFragment2 extends ListFragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_club_list, container, false);
//
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] clubTitles = getResources().getStringArray(R.array.club_titles);

        ArrayAdapter<String> clubTitlesAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, clubTitles);

//        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.club_titles, android.R.layout.simple_list_item_1);

        setListAdapter(clubTitlesAdapter);
//        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
// Access the Activity and cast to the inteface
        ClubListFragment.OnSelectedClubChangeListener listener = (ClubListFragment.OnSelectedClubChangeListener) getActivity();
        listener.onSelectedClubChangeListener(position);
    }
}
//

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//// Access the Activity and cast to the inteface
//        ClubListFragment.OnSelectedClubChangeListener listener = (ClubListFragment.OnSelectedClubChangeListener) getActivity();
//        listener.onSelectedClubChangeListener(position);
//    }
//}
