package com.shuja1497.fragments;


import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    // Interface Activity implements for notification
//    As long as the activity implements the interface, our DialogFragment derived class
//    can notify the activity of which button the user clicked.
    public interface OnButtonClickListener {
        void onButtonClick(int buttonId);
    }


    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,0);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_dialog, container, false);

        // Connect the Yes button click event and request focus
        View yesButton = v.findViewById(R.id.button_yes);
        yesButton.setOnClickListener(this);
        yesButton.requestFocus();
// Connect the No button click event
        View noButton = v.findViewById(R.id.button_no);
        noButton.setOnClickListener(this);

        // Set the dialog aspects of the dialog fragment
        Dialog dialog = getDialog();
        dialog.setTitle(getString(R.string.dialog_title));
        dialog.setCanceledOnTouchOutside(false);
        return v ;
    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();
// Notify the Activity of the button selection
        OnButtonClickListener parentActivity = (OnButtonClickListener) getActivity();
        parentActivity.onButtonClick(buttonId);
// Close the dialog fragment
        dismiss();
    }
}
