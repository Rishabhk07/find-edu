package com.example.rishabhkhanna.code_n_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rishabhkhanna.code_n_counter.UIs.TeacherSignup;

public class MainActivity extends AppCompatActivity {
    Button teacher;
    Button student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacher = (Button) findViewById(R.id.teacherSignup);
        student = (Button) findViewById(R.id.studentSignup);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(MainActivity.this ,TeacherSignup.class);
                startActivity(i);

            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this , );
//                startActivity(i);
            }
        });


    }
}
