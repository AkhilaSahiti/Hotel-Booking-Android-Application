package com.example.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.miniproject.room_types.RoomAvailability;

public class RegistrationPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page1);

        Button room = findViewById(R.id.rooms);
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RoomAvailability.class);
                startActivity(intent);
            }
        });
        Button facilities= findViewById(R.id.facilities);
        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Facilities.class);
                startActivity(intent);
            }
        });
        Button booking= findViewById(R.id.booking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Booking.class);
                startActivity(intent);
            }
        });
        Button rates= findViewById(R.id.rates);
        rates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RatesOfRooms.class);
                startActivity(intent);
            }
        });

    }
}
