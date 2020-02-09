package com.example.spont;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;

public class Map extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, LocationListener {
        //GoogleMap.OnMapClickListener,
        //GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    GoogleApiClient client;
    LocationRequest request;
    Marker currMarker;
    private LatLngBounds fence;
    EditText input;
    Button showBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        request = new LocationRequest().create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationRequest locationRequest = request.setInterval(1000);
        LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) {
            Toast.makeText(getApplicationContext(), "location could not be found", Toast.LENGTH_SHORT);
        }
        else {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            LatLng current = new LatLng(lat, lng);
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(current, 22);
            mMap.animateCamera(update);
            mMap.addMarker(new MarkerOptions().position(current)).showInfoWindow();

            //add bound 
            LatLng bound1 = new LatLng(lat-0.0043, lng-0.0043); //SW
            LatLng bound2 = new LatLng(lat+0.0043, lng+0.0043); //NE
            fence = new LatLngBounds(bound1, bound2);
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(fence, 0));

        }
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

        //mMap.setOnMapClickListener(this);
        //mMap.setOnMarkerClickListener(this);

        client = new GoogleApiClient.Builder(this).addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .build();
        // Add a marker in Sydney and move the camera
        //LatLng rochester = new LatLng(43, -77);
        //mMap.addMarker(new MarkerOptions().position(rochester).title("Marker in Rochester"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(rochester));
        mMap.setMinZoomPreference(18.0f);
        mMap.setMaxZoomPreference(22.0f);
        client.connect();
    }


    public void goToGroups(View view){
        startActivity(new Intent(Map.this, FriendAndGroups.class));

    }

    public void ping(View view) {
        startActivity(new Intent(Map.this, PingFriendOrGroup.class));
    }


    /**
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        markerForGeofence(latLng);

    }

    private void markerForGeofence(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Geofence Marker");

        if (markerOptions != null) {

            if (currMarker != null) {
                currMarker.remove();
            }

            currMarker = mMap.addMarker(markerOptions);
        }

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
    **/
}
