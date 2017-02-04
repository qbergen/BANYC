package com.example.queenabergen.banyc.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

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
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        mMap.addMarker(new MarkerOptions().position(location).title(programName).snippet(programType));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,17));

    }


}
