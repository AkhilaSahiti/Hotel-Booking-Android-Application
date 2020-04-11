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

public class PinGeneration extends AppCompatActivity {
    String mail, set_pin;
    EditText generated_email, pin_reset;
    Customer customer = new Customer();
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_generation);
        getIntent();

        generated_email = (EditText) findViewById(R.id.generated_email);
        mail = generated_email.getText().toString();

        pin_reset = (EditText) findViewById(R.id.pin_reset);
        set_pin = pin_reset.getText().toString();

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    validation();
                }
            }
        });

    }

    public boolean validation() {
        boolean valid = true;
        if (pin_reset.length() != 6 && (TextUtils.isEmpty(mail) || !Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
            Toast toast = Toast.makeText(this, "Invalid entries. Please re write the details!", Toast.LENGTH_LONG);
            toast.show();
            valid = false;
        }
        else{
            Toast toast = Toast.makeText(this, "PIN re-generated successfully!", Toast.LENGTH_SHORT);
            toast.show();
            valid = true;
        }

        return valid;
    }
}




