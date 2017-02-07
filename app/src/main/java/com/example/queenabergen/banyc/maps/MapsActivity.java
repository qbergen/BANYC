package com.example.queenabergen.banyc.maps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.queenabergen.banyc.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Hyun on 1/30/17.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String latitude;
    private String longitude;
    private String programName;
    private String programType;
    private String siteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_navi);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getRecyclerInfo();
    }

    private void getRecyclerInfo() {
        latitude = getIntent().getStringExtra("Latitude");
        longitude = getIntent().getStringExtra("Longitude");
        programName = getIntent().getStringExtra("Name");
        programType = getIntent().getStringExtra("Type");
        siteName = getIntent().getStringExtra("Site");
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        mMap.addMarker(new MarkerOptions()
                .position(location)
                .title(programName)
                .snippet(programType)
                .snippet(siteName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17));

    }
}
