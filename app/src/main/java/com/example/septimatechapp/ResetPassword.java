package com.example.septimatechapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    EditText ResetEmail;
    Button SendEmail;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        ResetEmail = (EditText) findViewById(R.id.emailText);
        SendEmail = (Button) findViewById(R.id.btnEmail);
        mAuth = FirebaseAuth.getInstance();

        SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = ResetEmail.getText().toString();

                if (TextUtils.isEmpty(userEmail)) {
                    Toast.makeText(ResetPassword.this, "Please Enter Email Id", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetPassword.this, "Please check your email to reset your password", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(ResetPassword.this, MainActivity.class));
                            } else {
                                String message = task.getException().getMessage();
                                Toast.makeText(ResetPassword.this, "Error Occured " + message, Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}