package com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rishabhkhanna.code_n_counter.Models.Event;
import com.example.rishabhkhanna.code_n_counter.R;
import com.example.rishabhkhanna.code_n_counter.UIs.New_Event;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import static com.example.rishabhkhanna.code_n_counter.R.layout.card_view_teacher;

/**
 * A simple {@link Fragment} subclass.
 */
public class Create_new_event extends Fragment {

    FirebaseListAdapter mAdapter;


    public Create_new_event() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_create_new_event, container, false);

        ListView messageView = (ListView) rootview.findViewById(R.id.listViewEvents);

//        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerViewEvent);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String teacherEmail = user.getEmail();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("events");

        ref.keepSynced(true);


        mAdapter = new FirebaseListAdapter<Event>(getActivity(), Event.class , R.layout.card_view_teacher , ref ) {
            @Override
            protected void populateView(View v, Event model, int position) {

                TextView ename = (TextView) v.findViewById(R.id.eventNameCardView);
                TextView teacherMail = (TextView) v.findViewById(R.id.teacheremailCardView);
                TextView date = (TextView) v.findViewById(R.id.dateCardView);
                TextView description = (TextView) v.findViewById(R.id.descriptionCardView);

                ename.setText(model.getEventName());
                teacherMail.setText(model.getTeacherId());
                date.setText(model.getDate());
                description.setText(model.getDescription());

                mAdapter.notifyDataSetChanged();

            }


        };

        messageView.setAdapter(mAdapter);









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
