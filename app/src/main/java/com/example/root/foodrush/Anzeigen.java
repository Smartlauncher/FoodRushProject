package com.example.root.foodrush;

import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBufferResponse;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Anzeigen extends AppCompatActivity  {
    private String TAG = "Orders";
            String   numb;
            String Name;
            String Preis ;
            int size = 1;
            String Zeitraum;
            String Ort;
            String Was;
            String Erstellung;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anzeigen);

BottomNavigationView mBottomNavigation;
mBottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);
mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                Intent intent = new Intent( Anzeigen.this , Order.class);
                startActivity(intent);

            case R.id.navigation_dashboard:
                Intent intent1 = new Intent( Anzeigen.this , Order.class);
                startActivity(intent1);



        }
        return false;
    }
});

        // Construct a GeoDataClient.
      //  mGeoDataClient = Places.getGeoDataClient(this, null);
//
      //  // Construct a PlaceDetectionClient.
      //  mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
//

//
        Window w = getWindow();
//
//
       w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS , WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);





//
//
  //      // Construct a GeoDataClient.
  //      mGeoDataClient = Places.getGeoDataClient(this, null);
//
  //      // Construct a PlaceDetectionClient.
  //      mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
//

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Anzeigen");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<generater> mList = new ArrayList<>();
                for(DataSnapshot ds:dataSnapshot.getChildren()){


                    for(DataSnapshot childSnapShot:ds.getChildren()){
                        if(childSnapShot.getKey().equals("Name")){
                            Name=childSnapShot.getValue().toString();
                        }
                        if(childSnapShot.getKey().equals("Was")){
                            Was=childSnapShot.getValue().toString();
                        }
                        if(childSnapShot.getKey().equals("Preis")){
                            Preis=childSnapShot.getValue().toString();
                        }
                        if(childSnapShot.getKey().equals("Ort")){
                            Ort=childSnapShot.getValue().toString();
                        }



                    }

                    RecyclerView recyclerView = findViewById(R.id.anzeigen_list);
                    RecyclerView.Adapter adapter = new generater_anzeigen_setter(Anzeigen.this,mList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Anzeigen.this));

                    mList.add(new generater(Name , Was , Preis ));




                    Log.d(TAG , "Name" + Name);
                    size++;

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }







}
