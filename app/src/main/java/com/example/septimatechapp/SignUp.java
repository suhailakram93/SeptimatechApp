package com.example.septimatechapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Intent intentMainPage;
    EditText editTextUserName, editTextEmail, editTextPswrd, editTextRe_Password;
    Button btnSignRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);
        editTextUserName = (EditText) findViewById(R.id.getUsername);
        editTextEmail = (EditText) findViewById(R.id.eMailS);
        editTextPswrd = (EditText) findViewById(R.id.password);
        editTextRe_Password = (EditText) findViewById(R.id.rePassword);
        intentMainPage = new Intent(this, MainActivity.class);
        btnSignRegister = (Button) findViewById(R.id.buttonRegister);

        btnSignRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if (editTextUserName.getText().toString().trim().isEmpty()) {
            editTextUserName.setError("Please fill the required details");

        } else if (editTextEmail.getText().toString().trim().isEmpty()) {
            editTextEmail.setError("Please fill the required details");

        } else if (editTextPswrd.getText().toString().trim().isEmpty()) {
            editTextPswrd.setError("Please fill the required details");

        } else if (
                editTextRe_Password.getText().toString().trim().isEmpty()) {
            editTextRe_Password.setError("Please fill the required details");
        } else if((editTextRe_Password.getText().toString().equals(editTextPswrd.getText().toString()))  )
        {
            startActivity(intentMainPage);
            Toast.makeText(this, "SIGN UP SUCCESSFULL", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Toast.makeText(this, "Please Enter Same Password", Toast.LENGTH_SHORT).show();

        }

    }


}
