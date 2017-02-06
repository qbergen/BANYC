package com.example.queenabergen.banyc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.queenabergen.banyc.sportsresources.SportsRv;
import com.example.queenabergen.banyc.subjects.business.BusinessPage;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class NaviActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewFlipper flip;
    private float initialX;

    public GridLayoutManager gridLayoutManager;
    public HomePageAdapter homePageAdapter;

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
        setBullentinBoard();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.homePageRecView);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        homePageAdapter = new HomePageAdapter();
        recyclerView.setAdapter(homePageAdapter);
    }

    public void setBullentinBoard() {
        int[] homePagePhotos = {R.drawable.youthiconapp88, R.drawable.employment, R.drawable.ladderposter,
                R.drawable.scienceflip, R.drawable.youthprogram, R.drawable.employmenttwo,
                R.drawable.nycwellflip, R.drawable.volunteerflip};
        ImageView picture1 = (ImageView) findViewById(R.id.picture1);
        ImageView picture2 = (ImageView) findViewById(R.id.picture2);
        ImageView picture3 = (ImageView) findViewById(R.id.picture3);
        ImageView picture4 = (ImageView) findViewById(R.id.picture4);
        ImageView picture5 = (ImageView) findViewById(R.id.picture5);
        ImageView picture6 = (ImageView) findViewById(R.id.picture6);
        ImageView picture7 = (ImageView) findViewById(R.id.picture7);
        ImageView picture8 = (ImageView) findViewById(R.id.picture8);

        for (int i = 0; i < homePagePhotos.length; i++) {
            ImageView[] viewFlipperImages = {picture1, picture2, picture3, picture4,
                    picture5, picture6, picture7, picture8};
            Picasso.with(getApplicationContext()).load(homePagePhotos[i]).into(viewFlipperImages[i]);
        }

        flip = (ViewFlipper) findViewById(R.id.home_Viewer);
        flip.setInAnimation(this, R.anim.right_enter);
        flip.setOutAnimation(this, R.anim.left_out);
        flip.setFlipInterval(2000);
        flip.startFlipping();
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
            Intent artsIntent = new Intent(getApplicationContext(), ArtsManagementPage.class);
            startActivity(artsIntent);
        } else if (id == R.id.nav_business) {
            Intent businessInten = new Intent(getApplicationContext(), BusinessPage.class);
            startActivity(businessInten);
        } else if (id == R.id.nav_stem) {

        } else if (id == R.id.nav_home) {
            Intent backHome = new Intent(getApplicationContext(), NaviActivity.class);
            startActivity(backHome);

        } else if (id == R.id.nav_athletics) {
            Intent goToSports = new Intent(getApplicationContext(), SportsRv.class);
            startActivity(goToSports);

        } else if (id == R.id.youth_employment) {
            Intent intent2 = new Intent(getApplicationContext(), LandingPage.class);
            startActivity(intent2);
        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
