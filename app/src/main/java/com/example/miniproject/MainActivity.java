package com.example.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniproject.models.Customer;
import com.example.miniproject.storage.Database;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login, newUser, forgot_pin;
    String getName,getpassword, check_pin;
    Database database = new Database(this);
    Customer customer = new Customer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIntent();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        newUser = (Button) findViewById(R.id.new_user);
        forgot_pin = (Button) findViewById(R.id.forgot_pin);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HotelSelection.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkDataEntered()) {
                    checkLoginDetails();
                } else {
                    checkDataEntered();
                }
            }
        });
        forgot_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PinGeneration.class);
                startActivity(intent);
            }
        });


    }
    public boolean checkDataEntered() {
        boolean valid = true;
        getName = username.getText().toString();
        getpassword = password.getText().toString();

        if (TextUtils.isEmpty(getName) || !Patterns.EMAIL_ADDRESS.matcher(getName).matches()) {
            Toast.makeText(this, "Enter valid email address!", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (getpassword.isEmpty() ) {
            Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }
    private void checkLoginDetails(){
        check_pin = database.checkLoginDetails(getName);
        if(getpassword.equals(check_pin)){
            customer = database.getCustomerDetails(getpassword);
            Intent intent = new Intent(this, BookingConfirmation.class);
            intent.setType("text/plain");
            intent.putExtra("customer", customer);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "UserId and Password donot match!", Toast.LENGTH_SHORT).show();
        }
    }
}

