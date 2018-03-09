package com.shuja1497.fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClubDescActivity extends AppCompatActivity {

    public static final String CLUB_INDEX = "club_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_desc);

        Intent intent = getIntent();
        int clubIndex = intent.getIntExtra(CLUB_INDEX,-1);

        if (clubIndex!=-1){
            // Use FragmentManager to access ClubDescFragment
            FragmentManager fm = getFragmentManager();
            ClubDescFragment bookDescFragment = (ClubDescFragment)
                    fm.findFragmentById(R.id.fragment_Description);
            // Display the club title
            bookDescFragment.setBook(clubIndex);
        }
    }
}
