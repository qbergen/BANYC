package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.queenabergen.banyc.subjects.business.BusinessPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NaviActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ImageView imageView;
    private static final String TAG = " ";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public Button signInBTN;
    public Button signupBTN;
    public EditText emailInput;
    public EditText passwordInput;
    public ImageView facebookView;
    public ImageView googleView;
    public Animation animFadeOut;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activenavi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loginView();
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void loginView() {
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
                overridePendingTransition(R.anim.fade_out, R.anim.activityanim);

            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_arts) {
            Intent artsIntent = new Intent(getApplicationContext(), ArtsAdapter.class);
            startActivity(artsIntent);
        } else if (id == R.id.nav_athletics) {
            Intent businessInten = new Intent(getApplicationContext(), BusinessPage.class);
            startActivity(businessInten);
        } else if (id == R.id.nav_stem) {

        } else if (id == R.id.youth_employment) {
            Intent intent2 = new Intent(getApplicationContext(), LandingPage.class);
            startActivity(intent2);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
