package com.example.miniproject.room_types;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.miniproject.R;

public class TripleBedroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triple_bedroom);
        getIntent();

        TextView slippers = findViewById(R.id.slippers);
        slippers.setMovementMethod(LinkMovementMethod.getInstance());


        TextView deposit_box= findViewById(R.id.deposit_box);
        deposit_box.setMovementMethod(LinkMovementMethod.getInstance());


        TextView tea = findViewById(R.id.tea);
        tea.setMovementMethod(LinkMovementMethod.getInstance());


        TextView hot_water = findViewById(R.id.hot_water);
        hot_water.setMovementMethod(LinkMovementMethod.getInstance());


        TextView AC= findViewById(R.id.AC);
        AC.setMovementMethod(LinkMovementMethod.getInstance());


        TextView tv = findViewById(R.id.tv);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
