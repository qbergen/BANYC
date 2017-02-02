package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {
    private static final String TAG = " ";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText mfirstName;
    private EditText mLastName;
    private Button createAccount;
    public EditText emailInput;
    public EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mfirstName = (EditText)findViewById(R.id.first_Name);
        mLastName = (EditText)findViewById(R.id.last_Name);
        emailInput = (EditText)findViewById(R.id.email_Input);
        passwordInput = (EditText)findViewById(R.id.password_Input);
        createAccount = (Button)findViewById(R.id.createAccount_btn);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                finish();
            }
        });
    }

    public void registerUser() {
        mAuth = FirebaseAuth.getInstance();
        String emailaddress = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String firstName = mfirstName.getText().toString();
        String lastName = mfirstName.getText().toString();
        mAuth.createUserWithEmailAndPassword(emailaddress, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Toast.makeText(CreateAccount.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CreateAccount.this, "Created Account Successfully",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                            startActivity(intent);

                        }

                        // ...
                    }
                });
    }
}
