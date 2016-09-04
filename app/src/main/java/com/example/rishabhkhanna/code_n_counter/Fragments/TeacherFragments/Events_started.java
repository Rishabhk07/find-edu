package com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rishabhkhanna.code_n_counter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Events_started extends Fragment {


    public Events_started() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View evenstStartedView  = inflater.inflate(R.layout.fragment_events_started, container, false);



        return evenstStartedView;
    }

}
