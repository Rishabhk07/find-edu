package com.example.rishabhkhanna.code_n_counter.UIs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rishabhkhanna.code_n_counter.Models.Event;
import com.example.rishabhkhanna.code_n_counter.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New_Event extends AppCompatActivity {
    EditText eventName;
    EditText teacherEmail;
    EditText date;
    EditText description;
    EditText topic;
    Button addEvent;
    Button location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__event);

        eventName = (EditText) findViewById(R.id.eventNameCardView);

        description = (EditText) findViewById(R.id.descriptionEvent);
        topic = (EditText) findViewById(R.id.topicEvent);

        addEvent = (Button) findViewById(R.id.addEvent);
        location = (Button) findViewById(R.id.addLocation);






        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String ename = eventName.getText().toString();
                String eteacheremail = user.getEmail();

                String edescription = description.getText().toString();
                String etopic= topic.getText().toString();



                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference ref = firebaseDatabase.getReference("events");

                DatabaseReference refTeacherEvent =firebaseDatabase.getReference("TeacherData").child("events");


                        String id = ref.push().getKey();
                ref.child(id).setValue(new Event(ename , eteacheremail , edescription ,etopic, id));
                refTeacherEvent.child(id).setValue(new Event(ename , eteacheremail , edescription ,etopic, id));


            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}
