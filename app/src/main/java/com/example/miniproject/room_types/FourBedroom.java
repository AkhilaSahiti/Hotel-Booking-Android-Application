package com.example.miniproject.room_types;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.miniproject.R;

public class FourBedroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_bedroom);
        getIntent();

        TextView tea_maker = findViewById(R.id.tea);
        tea_maker.setMovementMethod(LinkMovementMethod.getInstance());


        TextView tv = findViewById(R.id.tv);
        tv.setMovementMethod(LinkMovementMethod.getInstance());


        TextView wardrobe = findViewById(R.id.wardrobe);
        wardrobe.setMovementMethod(LinkMovementMethod.getInstance());


        TextView wifi = findViewById(R.id.wifi);
        wifi.setMovementMethod(LinkMovementMethod.getInstance());


        TextView workdesk = findViewById(R.id.workdesk);
        workdesk.setMovementMethod(LinkMovementMethod.getInstance());


        TextView hot_water = findViewById(R.id.hot_water);
        hot_water.setMovementMethod(LinkMovementMethod.getInstance());


        TextView towels = findViewById(R.id.towels);
        towels.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
