package com.example.septimatechapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends  AppCompatActivity {
    EditText name,email,pword,repass;
    Button regbtn;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);

        // connect with layout items
        name = (EditText) findViewById(R.id.getUsername);

        email = (EditText) findViewById(R.id.eMailS);
        pword = (EditText) findViewById(R.id.password);
        repass = (EditText) findViewById(R.id.rePassword);
        regbtn = (Button) findViewById(R.id.buttonRegister);
        fauth = FirebaseAuth.getInstance();

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = email.getText().toString().trim();
                 String pass = pword.getText().toString().trim();
                 String rpass = repass.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(SignUp.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(SignUp.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(rpass)) {
                    Toast.makeText(SignUp.this,"Re-enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length() < 8) {
                    Toast.makeText(SignUp.this,"Minimum 8 characters required",Toast.LENGTH_SHORT).show();

                }

                if(pass.equals(rpass)){
                    fauth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(SignUp.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(SignUp.this, "Error Occured", Toast.LENGTH_SHORT).show();


                            }
                        }
                    });

                }
            }
        });
    }}
