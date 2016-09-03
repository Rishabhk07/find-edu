package com.example.rishabhkhanna.code_n_counter.UIs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rishabhkhanna.code_n_counter.Models.student;
import com.example.rishabhkhanna.code_n_counter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentSignUp extends AppCompatActivity {

    public static final String TAG = "StudentData";
    EditText editTextName,editTextPassword,editTextAddress,editTextInstitute,editTextAge,editTextContact,editTextEmail;
    Button buttonSubmit,buttonOut;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_sign_up);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextContact = (EditText) findViewById(R.id.editTextContact);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextInstitute = (EditText) findViewById(R.id.editTextInstitute);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonSubmit  = (Button) findViewById(R.id.buttonSubmit);
        buttonOut = (Button) findViewById(R.id.buttonOut);

        mAuth  = FirebaseAuth.getInstance();


        buttonOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentSignUp.this,Student_Login.class);
                startActivity(intent);
            }
        });

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if(currentUser!=null){
                    Log.d("auth changed logined" , currentUser.getEmail());
                }else{
                    Log.d("auth changed logout" ," LOGOUT" );
                }

            }
        };


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = editTextEmail.getText().toString();
                final String password = editTextPassword.getText().toString();
                final String username = editTextName.getText().toString();
                final String institute = editTextInstitute.getText().toString();
                final String contact  = editTextContact.getText().toString();
                final int age = Integer.parseInt(editTextAge.getText().toString());

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(StudentSignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                if (!task.isSuccessful()) {
                                    Toast.makeText(StudentSignUp.this,"Failed",Toast.LENGTH_SHORT).show();
                                }
                                 if(task.isSuccessful()) {
                                     DatabaseReference mDatabase;
                                     mDatabase = FirebaseDatabase.getInstance().getReference("StudentData");
                                     //Creating object of Student
                                     student student = new student(username, email, password, institute, age, contact);
                                     mDatabase.push().setValue(student);
                                 }
                            }
                        });

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListner);
    }
}
