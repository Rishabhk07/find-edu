package com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rishabhkhanna.code_n_counter.R;
import com.example.rishabhkhanna.code_n_counter.UIs.New_Event;

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

        FloatingActionButton actionButton = (FloatingActionButton) rootview.findViewById(R.id.floating);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() , New_Event.class);
                startActivity(i);
            }
        });


        return rootview;
    }

}
