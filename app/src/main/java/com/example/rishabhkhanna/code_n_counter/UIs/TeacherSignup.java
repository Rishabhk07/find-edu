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

import com.example.rishabhkhanna.code_n_counter.Models.Teacher;
import com.example.rishabhkhanna.code_n_counter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherSignup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;
    EditText emailTeacher;
    EditText usernameTeacher;
    EditText qualificationTeacher;
    EditText workingAtTeacher;
    EditText contactTeacher;
    EditText ageTeacher;
    EditText passwordTeacher;
    Button signup;
    Button logOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_signup);
        mAuth = FirebaseAuth.getInstance();




        emailTeacher = (EditText) findViewById(R.id.emailTeacher);
        usernameTeacher = (EditText) findViewById(R.id.usernameTeacher);
        qualificationTeacher = (EditText) findViewById(R.id.qualificationTeacher);
        workingAtTeacher = (EditText) findViewById(R.id.workingAtTeacher);
        contactTeacher = (EditText) findViewById(R.id.contactTeacher);
        ageTeacher = (EditText) findViewById(R.id.age);
        passwordTeacher = (EditText) findViewById(R.id.passwordTeacher);
        signup = (Button) findViewById(R.id.signupTeacher);
        logOut = (Button) findViewById(R.id.logOut);






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

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailTeacher.getText().toString();
                final String password = passwordTeacher.getText().toString();

                final String qualification = qualificationTeacher.getText().toString();
                final String workingAt = workingAtTeacher.getText().toString();
                final String age = ageTeacher.getText().toString();
                final String username = usernameTeacher.getText().toString();
                final String contact = contactTeacher.getText().toString();





                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(TeacherSignup.this , new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Log.d("Sign Up complete " , "email: " +task.isSuccessful());

                                if(task.isSuccessful()){

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference ref = database.getReference("TeacherData");

                                    Teacher teacher  = new Teacher(username , email , password , qualification , workingAt ,age , contact  );

                                    ref.push().setValue(teacher);

                                    Intent i = new Intent(TeacherSignup.this , TeacherLandingPage.class);
                                    startActivity(i);


                                }

                                if(!task.isSuccessful()){
                                    Toast.makeText(TeacherSignup.this, "couldnt sign up now, try again later", Toast.LENGTH_SHORT).show();
                                    task.addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            e.printStackTrace();
                                        }
                                    });

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
        if(mAuthListner != null){
            mAuth.removeAuthStateListener(mAuthListner);
        }
    }
}
