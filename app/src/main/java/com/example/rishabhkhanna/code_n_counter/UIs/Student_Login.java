
package com.example.rishabhkhanna.code_n_counter.UIs;

import android.content.Intent;

import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rishabhkhanna.code_n_counter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Student_Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthstateListner;


    public EditText email,password;
    public TextView submit,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);

        mAuth =FirebaseAuth.getInstance();

        mAuthstateListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }

            }
        };


        email = (EditText) findViewById(R.id.loginIDstudent);
        password = (EditText) findViewById(R.id.passWord);
        submit = (TextView) findViewById(R.id.sign_IN);
        signup = (TextView) findViewById(R.id.notRegistered);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                if (emailString == "")
                    Toast.makeText(Student_Login.this, "Enter E-Mail", Toast.LENGTH_SHORT).show();
                else if (passwordString == "")
                    Toast.makeText(Student_Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                else {
                    mAuth.signInWithEmailAndPassword(emailString, passwordString)
                            .addOnCompleteListener(Student_Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Student_Login.this, "Login failed", Toast.LENGTH_SHORT).show();

                                    }
                                    if (task.isSuccessful()) {
                                        Intent i = new Intent(Student_Login.this, Student_Landing_Page.class);
                                        startActivity(i);
                                    }

                                }
                            });
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Student_Login.this , StudentSignUp.class);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthstateListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthstateListner);
    }
}