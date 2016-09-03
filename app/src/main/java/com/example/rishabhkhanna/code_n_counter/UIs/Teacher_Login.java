package com.example.rishabhkhanna.code_n_counter.UIs;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabhkhanna.code_n_counter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Teacher_Login extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthstateListner;

    public EditText email,password;
    public TextView submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);
        email = (EditText) findViewById(R.id.loginID);
        password = (EditText) findViewById(R.id.passWordTeacher);
        submit = (TextView) findViewById(R.id.sign_IN_Teacher);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                mAuth.signInWithEmailAndPassword(emailString , passwordString)
                        .addOnCompleteListener(Teacher_Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(!task.isSuccessful()){
                                    Toast.makeText(Teacher_Login.this, "Login failed", Toast.LENGTH_SHORT).show();

                                }
                                if(task.isSuccessful()){
                                    Intent i = new Intent(Teacher_Login.this
                                            , TeacherLandingPage.class);
                                    startActivity(i);
                                }

                            }
                        });

            }
        });



    }
    }

