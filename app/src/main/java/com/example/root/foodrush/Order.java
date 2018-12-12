package com.example.root.foodrush;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order extends AppCompatActivity
 //       implements GoogleMap.OnMyLocationButtonClickListener,
 //       GoogleMap.OnMyLocationClickListener,
 //       OnMapReadyCallback
  {
    private EditText order;
    private Switch boolean_input;
    private EditText timeframe;
    private EditText reward;
    private EditText Name;
    private EditText straße_in;
    private Button Submit;
    int numb;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);



       // SupportMapFragment mapFragment =
       //         (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googlemap);
       // mapFragment.getMapAsync(Order.this);
        BottomNavigationView mBottomNavigation;
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.navigation_order);
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Order.this, Order.class);
                        startActivity(intent1);

                    case R.id.navigation_home:
                        Intent intent = new Intent(Order.this, Anzeigen.class);
                        startActivity(intent);


                }
                return false;
            }
        });

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Anzeigen");
        final DatabaseReference myRef2 = database.getReference();
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                numb = Integer.parseInt(dataSnapshot.child("orderID").getValue().toString());
                numb = numb + 1;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        order = (EditText) findViewById(R.id.order_input);
        boolean_input = (Switch) findViewById(R.id.boolean_input);
        timeframe = (EditText) findViewById(R.id.timeframe_input);
        reward = (EditText) findViewById(R.id.reward_input);
        Submit = (Button) findViewById(R.id.Submit);
        Name = (EditText) findViewById(R.id.name_input);
        straße_in = (EditText) findViewById(R.id.straße_in);
        //  BottomNavigationView mBottomNavigation;
        //  mBottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        //  mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        //      @Override
        //      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //          switch (menuItem.getItemId()) {
        //              case R.id.navigation_home:
        //                  Intent intent = new Intent( Order.this , Anzeigen.class);
        //                  startActivity(intent);

        //              case R.id.navigation_dashboard:
        //                  Intent intent1 = new Intent( Order.this , Order.class);
        //                  startActivity(intent1);


        //          }
        //          return false;
        //      }
        //  });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String order_text = order.getText().toString();
                String timeframe_text = order.getText().toString();
                String reward_text = order.getText().toString();
                String name_text = Name.getText().toString();
                String straße_text = straße_in.getText().toString();
                boolean boolean_answer = Boolean.parseBoolean(boolean_input.getText().toString());
                final DatabaseReference myRef3 = database.getReference("orderID");

                myRef3.setValue(numb);


                myRef.child(String.valueOf(numb)).child("Was").setValue(order_text);
                myRef.child(String.valueOf(numb)).child("Preis").setValue(reward_text);
                myRef.child(String.valueOf(numb)).child("Name").setValue(name_text);
                myRef.child(String.valueOf(numb)).child("Straße").setValue(straße_text);
                myRef.child(String.valueOf(numb)).child("Zeitraum").setValue(timeframe_text);
                myRef.child(String.valueOf(numb)).child("Accept").setValue(false);
                myRef.child(String.valueOf(numb)).child("Dringend").setValue(boolean_answer);

            }
        });


    }

 // @Override
 // public void onMapReady(GoogleMap map) {
 //     mMap = map;
 //
 //     // location permission from the user. This sample does not include
 //     // a request for location permission.
 //     if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
 //
 //         //    ActivityCompat#requestPermissions
 //         // here to request the missing permissions, and then overriding
 //         //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
 //         //                                          int[] grantResults)
 //         // to handle the case where the user grants the permission. See the documentation
 //         // for ActivityCompat#requestPermissions for more details.
 //         mMap.setMyLocationEnabled(true);
 //         mMap.setOnMyLocationButtonClickListener(Order.this);
 //         mMap.setOnMyLocationClickListener(Order.this);
 //     }

 // }

 // @Override
 // public void onMyLocationClick(@NonNull Location location) {
 //     Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
 // }

 // @Override
 // public boolean onMyLocationButtonClick() {
 //     Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
 //     // Return false so that we don't consume the event and the default behavior still occurs
 //     // (the camera animates to the user's current position).
 //     return false;
 // }
}


