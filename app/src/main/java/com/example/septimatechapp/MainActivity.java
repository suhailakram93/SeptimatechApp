package com.example.septimatechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin,btnSignUp,btnForgotPaswrd;
    EditText username, password;
    Intent intentH,intentS;
    ImageButton imageButtonY,imageButtonL,imageButtonF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentH= new Intent(this,HomePage.class);
        intentS= new Intent(this,SignUp.class);
        username= (EditText) findViewById(R.id.u_id);
        password=(EditText) findViewById(R.id.p_id);
        btnLogin= (Button)findViewById(R.id.login);
        btnForgotPaswrd= (Button)findViewById(R.id.btnFrgt);
        btnSignUp= (Button)findViewById(R.id.btnSignup) ;
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        btnForgotPaswrd.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.login):
                if (username.getText().toString().trim().isEmpty() ) {
                    username.setError("please fill the required details");
                } else if( password.getText().toString().trim().isEmpty()) {
                    password.setError("please fill the required details");
                }else {
                    startActivity(intentH);
                }
                break;

            case (R.id.btnSignup):
                startActivity(intentS);
                break;
        }

    }
}
