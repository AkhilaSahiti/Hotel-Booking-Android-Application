package com.example.miniproject;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject.models.Customer;

public class BookingConfirmation extends AppCompatActivity {

    Button confirmBooking;
    ImageButton edit_button, main_page_button, first_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        final Intent intent = getIntent();
        final Customer customer = (Customer) intent.getSerializableExtra("customer");

        TextView name = (TextView) findViewById(R.id.name_entered);
        name.setText(customer.getName());

        TextView phno = (TextView) findViewById(R.id.phno_entered);
        phno.setText(String.valueOf(customer.getPhone()));

        TextView email = (TextView) findViewById(R.id.email_entered);
        email.setText(customer.getEmail());

        TextView rooms = (TextView) findViewById(R.id.room_entered);
        rooms.setText(customer.getRoom_type());

        TextView staydays = (TextView) findViewById(R.id.stay_days_entered);
        staydays.setText(String.valueOf(customer.getStay_days()));


        Toast toast = Toast.makeText(this, "Congratulations! Booking is done...", Toast.LENGTH_SHORT);
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

        edit_button = (ImageButton) findViewById(R.id.edit_btn);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingConfirmation.this,Booking.class);
                intent.putExtra("customer",customer);
                startActivity(intent);
            }
        });
        main_page_button= (ImageButton) findViewById(R.id.main_page);
        main_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingConfirmation.this,HotelSelection.class);
                startActivity(intent);
            }
        });
        first_screen = (ImageButton) findViewById(R.id.first_screen);
        first_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingConfirmation.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //confirmBooking = (Button) findViewById(R.id.cust_booking);
    }
    protected void onemail() {

        String[] TO = {""};
        Intent mailintent = new Intent(Intent.ACTION_SEND);
        mailintent.setData(Uri.parse("mailto:"));
        mailintent.setType("text/plain");
        mailintent.putExtra(Intent.EXTRA_EMAIL, TO);
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
