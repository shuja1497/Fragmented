package com.shuja1497.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ClubListFragment.OnSelectedClubChangeListener

        , MyDialogFragment.OnButtonClickListener{

    private int mSelectedClubIndex;
    private MyDialogFragment mMyDialogFragment;
    private boolean mIsFragmentDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction= mFragmentManager.beginTransaction();
        Fragment clubDescrFrag = mFragmentManager.findFragmentById(R.id.fragment_Description);

        mIsFragmentDynamic = clubDescrFrag == null || !clubDescrFrag.isInLayout();

        if (mIsFragmentDynamic){
            ClubListFragment2 frag = new ClubListFragment2();
            mFragmentTransaction.add(R.id.root_layout, frag, "ListFragment");
            mFragmentTransaction.commit();
        }
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

        mSelectedClubIndex = clubIndex;
        // Access the FragmentManager
        FragmentManager mFragmentManager = getFragmentManager();
// Get the club description fragment
        ClubDescFragment mClubDescFragment = new ClubDescFragment();
        mClubDescFragment = (ClubDescFragment)
                mFragmentManager.findFragmentById(R.id.fragment_Description);


        mMyDialogFragment = new MyDialogFragment();
        mMyDialogFragment.show(getFragmentManager(), null);
    }

    @Override
    public void onButtonClick(int buttonId) {

        ClubDescFragment mClubDescFragment;
        FragmentManager mFragmentManager = getFragmentManager();

        switch (buttonId){
            case R.id.button_yes:
                // Check validity of fragment reference
//                if (mClubDescFragment == null  || !mClubDescFragment.isVisible() ){
                    // Use activity to display description
//                    Intent intent = new Intent(this, ClubDescActivity.class);
//                    intent.putExtra(ClubDescActivity.CLUB_INDEX, mSelectedClubIndex);
//                    startActivity(intent);
                if (mIsFragmentDynamic){
                    FragmentTransaction mFragmentTransaction= mFragmentManager.beginTransaction();
                    ClubDescFragment clubDescFragment = new ClubDescFragment();
                    Bundle args = new Bundle();
                    args.putInt(ClubDescFragment.CLUB_INDEX, mSelectedClubIndex);
                    clubDescFragment.setArguments(args);
//                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.root_layout, clubDescFragment, "ClubDescription");
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out);
                    mFragmentTransaction.commit();
                }
                else {
                    // Use contained fragment to display description
                    mClubDescFragment = (ClubDescFragment) mFragmentManager.findFragmentById(R.id.fragment_Description);
                    mClubDescFragment.setClub(mSelectedClubIndex);
                }
                break;
            case R.id.button_no:
                mMyDialogFragment.dismiss();
                break;
        }
    }
}
