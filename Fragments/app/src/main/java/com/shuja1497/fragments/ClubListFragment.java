package com.shuja1497.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnSelectedClubChangeListener} interface
 * to handle interaction events.
 * Use the {@link ClubListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClubListFragment extends android.app.Fragment
        implements RadioGroup.OnCheckedChangeListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnSelectedClubChangeListener mListener;
    private OnSelectedClubChangeListener mClubChangeListener;

    public ClubListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClubListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClubListFragment newInstance(String param1, String param2) {
        ClubListFragment fragment = new ClubListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        // Connect the listener to the radio group
        RadioGroup group = view.findViewById(R.id.bookSelectGroup);
        group.setOnCheckedChangeListener(this);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectedClubChangeListener) {
            mClubChangeListener = (OnSelectedClubChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSelectedClubChangeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mClubChangeListener = null;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // Translate radio button to book index
        int bookIndex = translateIdToIndex(checkedId);

        // Get parent Activity and send notification
//        mClubChangeListener = (OnSelectedClubChangeListener) getActivity();
        if (mClubChangeListener!=null)
            mClubChangeListener.onSelectedClubChangeListener(bookIndex);

    }

    private int translateIdToIndex(int checkedId) {
        int index = -1;
        switch (checkedId) {
            case R.id.radioButton:
                index = 0 ;
                break;
            case R.id.radioButton2:
                index = 1 ;
                break;
            case R.id.radioButton3:
                index = 2 ;
                break;
            case R.id.radioButton4:
                index = 3 ;
                break;
        }
        return index;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSelectedClubChangeListener {
        void onSelectedClubChangeListener(int clubIndex);
    }
}
