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

import com.example.queenabergen.banyc.facebook.FacebookLoginActivity;
import com.example.queenabergen.banyc.google.GoogleLoginActivity;
import com.facebook.CallbackManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = " ";
    private Button facebookBtn;
    private ImageView googleBtn;
    private CallbackManager callbackManager;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public Button signInBTN;
    public Button signupBTN;
    public EditText emailInput;
    public EditText passwordInput;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        callbackManager = CallbackManager.Factory.create();
        loginView();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void loginView() {
        facebookBtn = (Button) findViewById(R.id.login_button);
        facebookBtn.setOnClickListener(this);
        googleBtn = (ImageView) findViewById(R.id.google_btn);
        googleBtn.setOnClickListener(this);
        passwordInput = (EditText) findViewById(R.id.password_input);
        passwordInput.setElevation(50);
        emailInput = (EditText) findViewById(R.id.email_input);
        emailInput.setElevation(50);
        signInBTN = (Button) findViewById(R.id.signin_btn);
        signInBTN.setElevation(50);
        signInBTN.setOnClickListener(this);
        signupBTN = (Button) findViewById(R.id.signup_btn);
        signupBTN.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Intent fbIntent = new Intent(getApplicationContext(), FacebookLoginActivity.class);
                startActivity(fbIntent);
                break;
            case R.id.google_btn:
                Intent googleIntent = new Intent(getApplicationContext(), GoogleLoginActivity.class);
                startActivity(googleIntent);
                break;
            case R.id.signin_btn:
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
                    }
                };
                break;
            case R.id.signup_btn:
                Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_out, R.anim.activityanim);
                break;
        }
    }
}