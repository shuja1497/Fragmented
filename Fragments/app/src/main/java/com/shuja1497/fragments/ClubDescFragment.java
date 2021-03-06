package com.shuja1497.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
// * {@link .} interface
 * to handle interaction events.
 * Use the {@link ClubDescFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClubDescFragment extends android.app.Fragment {

    // Book index argument name
    public static final String CLUB_INDEX = "club_index";
    // Book index default value
    private static final int CLUB_INDEX_NOT_SET = -1;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    String[] mClubDescriptions;
    TextView mClubDescriptionTextView;

//    private OnFragmentInteractionListener mListener;

    public ClubDescFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClubDescFragment.
     */
    public static ClubDescFragment newInstance(String param1, String param2) {
        ClubDescFragment fragment = new ClubDescFragment();
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
        View view = inflater.inflate(R.layout.fragment_book_disc, container, false);

        mClubDescriptions = getResources().getStringArray(R.array.description_array);
        mClubDescriptionTextView = view.findViewById(R.id.textView);

        // Retrieve the club index if attached
        Bundle args = getArguments();
        int bookIndex = args != null ?args.getInt(CLUB_INDEX, CLUB_INDEX_NOT_SET) : CLUB_INDEX_NOT_SET;

        // If we find the club index, use it
        if (bookIndex != CLUB_INDEX_NOT_SET)
            setClub(bookIndex);

        return view;
    }

//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    public void setClub(int bookIndex) {
// Lookup the book description
        String clubDescription = mClubDescriptions[bookIndex];
// Display it
        mClubDescriptionTextView.setText(clubDescription);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnSelectedClubChangeListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
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
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
