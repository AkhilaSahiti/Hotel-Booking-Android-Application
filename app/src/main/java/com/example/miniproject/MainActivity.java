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
    Button login, newUser;
    String getName, getEmail, getContact, getRoom_type, getStay_days, getpassword;
    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        newUser = (Button) findViewById(R.id.new_user);

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
                    checkLoginDetails(username.getText().toString(),password.getText().toString());
                    displayScreen();
                } else {
                    checkDataEntered();
                }
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

    public void displayScreen(){
        Intent intent = new Intent(this, BookingConfirmation.class);
        intent.setType("text/plain");

        intent.putExtra("ur_name", getName);
        intent.putExtra("ur_phone", getContact);
        intent.putExtra("ur_email", getEmail);
        intent.putExtra("ur_rooms", getRoom_type);
        intent.putExtra("ur_stay_days", getStay_days);
        startActivity(intent);
    }
    private void checkLoginDetails(String checkId, String checkPin){
        Database database = new Database(this);
        database.checkLoginDetails(this, checkId, checkPin, new Database.DatabaseCallback() {
            @Override
            public void onCompletion(boolean success) {
                //Todo: Nothing
            }

            @Override
            public void onCustomersRetrieved(List<Customer> employees) {

            }

        });
    }
}
 /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName = username.getText().toString();
                getpassword = password.getText().toString();

                if (TextUtils.isEmpty(getName) || !Patterns.EMAIL_ADDRESS.matcher(getName).matches()) {
                    showMessage("Oops!", "Enter valid Email ID...");

                } else if ( getpassword.isEmpty()) {
                    showMessage("Oops!", "Enter valid 6 digit password...");

                }

                SQLiteDatabase db = database.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM custTable WHERE column_name='"
                        + username.getText().toString().trim() + "'" +
                        "AND column_pin='"+password.getText().toString().trim()+"'", null);
                if(cursor.moveToFirst()){
                    getName = cursor.getString(1);
                    getContact = cursor.getString(2);
                    getEmail = cursor.getString(3);
                    getRoom_type = cursor.getString(4);
                    getStay_days = cursor.getString(5);
                    displayscreen();
                } else {
                    showMessage("Oops!", "Username and password doesnot match. Please refill the details properly...");
                }
                cursor.close();

            }
        });
        public void showMessage(String title,String message)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

        */

