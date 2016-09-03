package com.example.rishabhkhanna.code_n_counter.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rishabhkhanna.code_n_counter.Models.Event;
import com.example.rishabhkhanna.code_n_counter.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New_Event extends AppCompatActivity {
    EditText eventName;
    EditText teacherEmail;
    EditText date;
    EditText description;
    EditText topic;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__event);

        eventName = (EditText) findViewById(R.id.eventNameCardView);
        teacherEmail = (EditText) findViewById(R.id.emailEventTeacher);
        date = (EditText) findViewById(R.id.dateEvent);
        description = (EditText) findViewById(R.id.descriptionEvent);
        topic = (EditText) findViewById(R.id.topicEvent);

        addEvent = (Button) findViewById(R.id.addEvent);


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ename = eventName.getText().toString();
                String eteacheremail = teacherEmail.getText().toString();
                String edate = date.getText().toString();
                String edescription = description.getText().toString();
                String etopic= topic.getText().toString();



                Event event = new Event(ename , eteacheremail , edate, edescription ,etopic );

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference ref = firebaseDatabase.getReference("events");
                ref.push().setValue(event);


            }
        });




    }
}
