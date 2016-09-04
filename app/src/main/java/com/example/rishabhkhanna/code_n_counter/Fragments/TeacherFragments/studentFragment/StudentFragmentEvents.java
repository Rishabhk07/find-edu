package com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments.studentFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rishabhkhanna.code_n_counter.Models.Event;
import com.example.rishabhkhanna.code_n_counter.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragmentEvents extends Fragment {


    FirebaseListAdapter mAdapter;



    public StudentFragmentEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_student_fragment_events, container, false);

        ListView messageview = (ListView) root.findViewById(R.id.listViewStudentEvents);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String teacherEmail = user.getEmail();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("events");


        ref.keepSynced(true);


        mAdapter = new FirebaseListAdapter<Event>(getActivity(), Event.class , R.layout.student_card_view , ref ) {
            @Override
            protected void populateView(View v, final Event model, int position) {



                TextView ename = (TextView) v.findViewById(R.id.eventNameCardView);
                TextView teacherMail = (TextView) v.findViewById(R.id.teacheremailCardView);

                TextView description = (TextView) v.findViewById(R.id.descriptionCardView);


                Button addme = (Button) v.findViewById(R.id.addme);

                addme.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference ref = database.getReference("events");
                        DatabaseReference refTeacher = database.getReference("TeacherData").child("events");
                        ref.child(model.getEid());
                        int c = Integer.parseInt(model.getCount());
                        c++;
                        model.setCount(String.valueOf(c));
                        ref.child(model.getEid()).setValue(model);
                        refTeacher.child(model.getEid()).setValue(model);


                    }
                });



                ename.setText(model.getEventName());
                teacherMail.setText(model.getTeacherId());

                description.setText(model.getDescription());

                mAdapter.notifyDataSetChanged();


            }


        };

        messageview.setAdapter(mAdapter);




        return root;
    }

}
