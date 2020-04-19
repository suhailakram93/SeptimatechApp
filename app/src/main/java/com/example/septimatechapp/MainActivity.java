package com.example.septimatechapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;

import static com.example.septimatechapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private SignInButton logInButton;
    private GoogleSignInClient logInClient;
    private String TAG = "MainActivity";
    private FirebaseAuth mAuth, auth;
    private Button logOutButton;
    private int RC_SIGN_IN = 1;

    Button btnLogin, btnSignUp, btnForgotPaswrd, microbtn;
    EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        logInButton = findViewById(R.id.log_in_button);
        mAuth = FirebaseAuth.getInstance();
        auth = FirebaseAuth.getInstance();
        logOutButton = findViewById(R.id.log_out_button);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        logInClient = GoogleSignIn.getClient(this, gso);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn(
                );

            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInClient.signOut();
                Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
                logOutButton.setVisibility(View.INVISIBLE);
            }
        });

        username = (EditText) findViewById(R.id.u_id);
        password = (EditText) findViewById(R.id.p_id);
        btnLogin = (Button) findViewById(R.id.login);
        btnForgotPaswrd = (Button) findViewById(R.id.btnFrgt);
        btnSignUp = (Button) findViewById(R.id.btnSignup);
        microbtn = (Button) findViewById(R.id.microsoft_button);
        microbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OAuthProvider.Builder provider = OAuthProvider.newBuilder("microsoft.com");
                Task<AuthResult> pendingResultTask = auth.getPendingAuthResult();
                if (pendingResultTask != null) {
                    // There's something already here! Finish the sign-in for your user.
                    pendingResultTask
                            .addOnSuccessListener(
                                    new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            // User is signed in.
                                            // IdP data available in
                                            // authResult.getAdditionalUserInfo().getProfile().
                                            // The OAuth access token can also be retrieved:
                                            // authResult.getCredential().getAccessToken().
                                            // The OAuth ID token can also be retrieved:
                                            // authResult.getCredential().getIdToken().
                                        }
                                    })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle failure.
                                        }
                                    });
                } else {
                    // There's no pending result so you need to start the sign-in flow.
                    // See below.
                    auth
                            .startActivityForSignInWithProvider(/* activity= */ MainActivity.this, provider.build())
                            .addOnSuccessListener(
                                    new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            startActivity(new Intent(getApplicationContext(), HomePage.class));

                                        }
                                    })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                                        }
                                    });
                }
            }
        });

        btnForgotPaswrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPassword.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length() < 8) {
                    Toast.makeText(MainActivity.this, "Minimum 8 characters required", Toast.LENGTH_SHORT).show();

                }
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (username.getText().toString().equals("c@gmail.com")) {
                            username.setText("");
                            password.setText("");
                            startActivity(new Intent(getApplicationContext(), Adminmain.class));

                        } else if (task.isSuccessful()) {
                            username.setText("");
                            password.setText("");
                            startActivity(new Intent(getApplicationContext(), HomePage.class));

                        } else {
                            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }


    private void logIn() {
        Intent signInIntent = logInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {

            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
           // Toast.makeText(MainActivity.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        } catch (ApiException e) {
            Toast.makeText(MainActivity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        //check if the account is null
        if (acct != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);

                    } else {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser fUser) {
        logOutButton.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(MainActivity.this, personName + personEmail, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomePage.class));
        }

    }
}

