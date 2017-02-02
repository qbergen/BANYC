package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = " ";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public Button signInBTN;
    public Button signupBTN;
    public EditText emailInput;
    public EditText passwordInput;
    public ImageView facebookView;
    public ImageView googleView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        loginView();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void loginView() {
        mAuth = FirebaseAuth.getInstance();
        facebookView = (ImageView) findViewById(R.id.facebook_btn);
        googleView = (ImageView) findViewById(R.id.google_btn);
        passwordInput = (EditText) findViewById(R.id.password_input);
        passwordInput.setElevation(50);
        emailInput = (EditText) findViewById(R.id.email_input);
        emailInput.setElevation(50);
        signInBTN = (Button) findViewById(R.id.signin_btn);
        signInBTN.setElevation(50);
        signInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null) {
                            // User is signed in
                            Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                            Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                            startActivity(intent);
                        } else {
                            // User is signed out
                            Log.d(TAG, "onAuthStateChanged:signed_out");
                        }
                        // ...
                    }
                };
            }
        });
        signupBTN = (Button) findViewById(R.id.signup_btn);
        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
                startActivity(intent);
            }
        });
    }


}
