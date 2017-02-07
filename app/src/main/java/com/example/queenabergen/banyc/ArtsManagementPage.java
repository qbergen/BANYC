package com.example.queenabergen.banyc;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.queenabergen.banyc.sportsresources.SportsRv;
import com.example.queenabergen.banyc.subjects.business.BusinessPage;

public class ArtsManagementPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public LinearLayoutManager linearLayoutManager;
    public ArtsAdapter artsAdapter;
    private Toolbar toolbar;
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artsnavi);

        hamburgerToolBar();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.artsPageRecView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        artsAdapter = new ArtsAdapter();
        recyclerView.setAdapter(artsAdapter);

    }

    private void hamburgerToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_arts);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.arts_drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    @SuppressWarnings("StatementWithEmptyBody")
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

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
