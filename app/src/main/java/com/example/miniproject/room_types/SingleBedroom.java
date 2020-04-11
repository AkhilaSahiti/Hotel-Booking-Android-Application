package com.example.miniproject.room_types;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.miniproject.R;

public class SingleBedroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bedroom);
        getIntent();

        TextView slippers = findViewById(R.id.slippers);
        slippers.setMovementMethod(LinkMovementMethod.getInstance());


        TextView room_service = findViewById(R.id.room_service);
        room_service.setMovementMethod(LinkMovementMethod.getInstance());


        TextView wardrobe = findViewById(R.id.wardrobe);
        wardrobe.setMovementMethod(LinkMovementMethod.getInstance());


        TextView wifi = findViewById(R.id.wifi);
        wifi.setMovementMethod(LinkMovementMethod.getInstance());


        TextView bathroom= findViewById(R.id.bathroom);
        bathroom.setMovementMethod(LinkMovementMethod.getInstance());


        TextView AC = findViewById(R.id.AC);
        AC.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
