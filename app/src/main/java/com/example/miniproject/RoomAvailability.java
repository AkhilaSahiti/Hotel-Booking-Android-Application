package com.example.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RoomAvailability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_availability);
        getIntent();
    }
}
