package com.example.miniproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Facilities extends AppCompatActivity {

    String[] strings = { "Car parking", "Swimming Pool", "Outdoor Restaurant", "Spa", "Laundry Service", "Meeting Facilites", "Free wireless internet access", "24-Hour room service", "Club", "Hospitality",
            "Gym" ,"Television", "Air Condition"} ;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
        getIntent();

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_facilities, R.id.app_name, strings);
        listView =(ListView) findViewById(R.id.list_of_facilities);
        listView.setAdapter(arrayAdapter);

    }

}
