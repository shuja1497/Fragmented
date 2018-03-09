package com.shuja1497.fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ClubListFragment.OnSelectedClubChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedClubChangeListener(int clubIndex) {
        // Access the FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
// Get the club description fragment
        ClubDescFragment clubDescFragment = (ClubDescFragment)
                fragmentManager.findFragmentById(R.id.fragment_Description);

        // Check validity of fragment reference
        if (clubDescFragment == null  || !clubDescFragment.isVisible() ){
            // Use activity to display description
            Intent intent = new Intent(this, ClubDescActivity.class);
            intent.putExtra(ClubDescActivity.CLUB_INDEX, clubIndex);
            startActivity(intent);
        }
        else {
            // Use contained fragment to display description
            clubDescFragment.setBook(clubIndex);
        }
    }
}
