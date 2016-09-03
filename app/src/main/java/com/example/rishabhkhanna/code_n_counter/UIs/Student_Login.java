package com.example.rishabhkhanna.code_n_counter.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.EditText;
import android.widget.TextView;


import com.example.rishabhkhanna.code_n_counter.R;

public class Student_Login extends AppCompatActivity {


    public EditText email,password;
    public TextView submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);




        email = (EditText) findViewById(R.id.loginID);
        password = (EditText) findViewById(R.id.passWord);
        submit = (TextView) findViewById(R.id.sign_IN);

    }
}
