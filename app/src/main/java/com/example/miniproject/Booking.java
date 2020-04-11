package com.example.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.miniproject.models.Customer;
import com.example.miniproject.storage.Database;

import java.util.List;

public class Booking extends AppCompatActivity {

    Button bookingbtn;
    Spinner roomSpinner;
    private EditText name, phno, email, staydays, pin;
    private String cname,  cphno, cemail, crooms, cstaydays, cpin;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        database = new Database(this);

        name = (EditText) findViewById(R.id.customer_name);
        phno = (EditText) findViewById(R.id.customer_phone);
        email = (EditText) findViewById(R.id.customer_email);
        roomSpinner = (Spinner) findViewById(R.id.room_spinner);
        staydays = (EditText) findViewById(R.id.customer_stay_days);
        pin= (EditText) findViewById(R.id.customer_pin);
        bookingbtn = (Button) findViewById(R.id.cust_booking);

        final Intent intent = getIntent();
        final Customer customer = (Customer) intent.getSerializableExtra("customer");
        if(customer!= null){
            name.setText(customer.getName());
            phno.setText(String.valueOf(customer.getPhone()));
            email.setText(customer.getEmail());

            ArrayAdapter myAdap1 = (ArrayAdapter) roomSpinner.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap1.getPosition(customer.getRoom_type());
            roomSpinner.setSelection(spinnerPosition);

            staydays.setText(String.valueOf(customer.getStay_days()));
            pin.setText(String.valueOf(customer.getPin()));

        }
        bookingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataEntered()) {
                    final Customer customer = new Customer();
                    customer.setName(cname);
                    customer.setPhone(Long.parseLong(cphno));
                    customer.setEmail(cemail);
                    customer.setRoom_type(crooms);
                    customer.setStay_days(Integer.parseInt(cstaydays));
                    customer.setPin(Integer.parseInt(cpin));

                    database.addCustomer(Booking.this, customer, new Database.DatabaseCallback() {
                        @Override
                        public void onCompletion(boolean success) {
                            if(success) {
                                Intent intent = new Intent(getApplicationContext(), BookingConfirmation.class);
                                intent.putExtra("customer", customer);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCustomersRetrieved(List<Customer> employees) {
                            //ToDo: Nothing
                        }

                    });
                } else {
                    checkDataEntered();
                }
            }
        });
    }

    public boolean checkDataEntered() {
        boolean valid = true;

        cname = name.getText().toString();
        cphno = phno.getText().toString();
        cemail= email.getText().toString();
        crooms = roomSpinner.getSelectedItem().toString().trim();
        cstaydays = staydays.getText().toString();
        cpin = pin.getText().toString();

        if (cname.length() < 3 || cname.isEmpty()) {
            Toast toast = Toast.makeText(this, "Name should contain atleast 3 letters!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cphno.length()!= 10 || cphno.isEmpty()) {
            Toast toast = Toast.makeText(this, "Number should have 10 digits", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (TextUtils.isEmpty(cemail) || !Patterns.EMAIL_ADDRESS.matcher(cemail).matches()) {
            Toast.makeText(this, "Enter valid email address!", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (crooms.equalsIgnoreCase("Choose any") || crooms.isEmpty()) {
            Toast toast = Toast.makeText(this, "Choose any Room Type!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cstaydays.length() == 0 || cphno.isEmpty()) {
            Toast toast = Toast.makeText(this, "Stay Days should be atleast 1", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cpin.length() != 6 || cpin.isEmpty()) {
            Toast toast = Toast.makeText(this, "PIN should contain 6 digits ", Toast.LENGTH_LONG);
            toast.show();
            valid = false;
        }
        return valid;
    }
}
