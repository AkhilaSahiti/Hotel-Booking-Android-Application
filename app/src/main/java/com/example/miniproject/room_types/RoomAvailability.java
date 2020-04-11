package com.example.miniproject.room_types;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.example.miniproject.R;

public class RoomAvailability extends AppCompatActivity {

    GridLayout singleBedLayout, doubleBedLayout, tripleBedLayout, fourBedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_availability);
        getIntent();

        singleBedLayout = (GridLayout) findViewById(R.id.on_click_singleBed);
        doubleBedLayout = (GridLayout) findViewById(R.id.on_click_doubleBed);
        tripleBedLayout = (GridLayout) findViewById(R.id.on_click_tripleBed);
        fourBedLayout = (GridLayout) findViewById(R.id.on_click_fourBed);

        singleBedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SingleBedroom.class);
                startActivity(intent);
            }
        });

        doubleBedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DoubleBedroom.class);
                startActivity(intent);
            }
        });

        tripleBedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TripleBedroom.class);
                startActivity(intent);
            }
        });

        fourBedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FourBedroom.class);
                startActivity(intent);
            }
        });
    }
}
