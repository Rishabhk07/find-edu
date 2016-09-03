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
public class Create_new_event extends Fragment {


    public Create_new_event() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_create_new_event, container, false);
        return rootview;
    }

}
