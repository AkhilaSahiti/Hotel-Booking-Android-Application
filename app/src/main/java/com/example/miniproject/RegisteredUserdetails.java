package com.example.miniproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisteredUserdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_userdetails);

        Toast toast = Toast.makeText(this, "Booking has been done...", Toast.LENGTH_SHORT);
        toast.show();
        Button send_email = (Button) findViewById(R.id.sendemail);
        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onemail();
            }
        });

        Button send_sms = (Button) findViewById(R.id.sendsms);
        send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsms();
            }
        });

        ImageButton edit_button = (ImageButton) findViewById(R.id.edit_btn);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisteredUserdetails.this,Booking.class);
                startActivity(intent);
            }
        });
        ImageButton main_page_button= (ImageButton) findViewById(R.id.main_page);
        main_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisteredUserdetails.this,HotelSelection.class);
                startActivity(intent);
            }
        });
    }
    protected void onemail() {

        Intent mailintent = new Intent(Intent.ACTION_SEND);
        mailintent.setData(Uri.parse("mailto:"));
        mailintent.putExtra(Intent.EXTRA_SUBJECT, "Customer Booking");
        mailintent.putExtra(Intent.EXTRA_TEXT, "Congratulations. Your booking has been done.");
        startActivity(mailintent);

    }

    protected void onsms() {
        Intent smsintent = new Intent(Intent.ACTION_SEND);
        smsintent.setData(Uri.parse("sms:"));
        smsintent.putExtra(Intent.EXTRA_SUBJECT, "Congratulations. Your booking has been done.");
        startActivity(smsintent);

    }

    }
