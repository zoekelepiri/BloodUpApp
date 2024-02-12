package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpHospital extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_hospital);
        final HospitalDatabase hospitalDatabase = new HospitalDatabase(this);

        EditText hospitalName = (EditText)findViewById(R.id.signup_name);
        EditText hospitalPhone = (EditText)findViewById(R.id.signup_phone);
        EditText hospitalEmail = (EditText)findViewById(R.id.signup_email);
        EditText hospitalPassword = (EditText)findViewById(R.id.signup_password);
        final Spinner hospitalLocation = (Spinner)findViewById(R.id.LocationSpinnerDonorRegister);


        final Button signUpButton = (Button)findViewById(R.id.signup_button);
        signUpButton.setOnClickListener(v -> {

            // check for the values of the fields
            // if empty --> toast message
            if (hospitalName.getText().toString().isEmpty() || hospitalPhone.getText().toString().isEmpty() || hospitalEmail.getText().toString().isEmpty() || hospitalPassword.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            }
            // create on the database the new hospital and redirect to the activity
            else {
                hospitalDatabase.createNewHospital(
                        hospitalName.getText().toString(),
                        Integer.parseInt(hospitalPhone.getText().toString()),
                        hospitalEmail.getText().toString(),
                        hospitalPassword.getText().toString(),
                        hospitalLocation.getSelectedItem().toString()
                );
                // inform the user about the successful sign up
                Toast.makeText(getApplicationContext(), "Registration Completed Successfully!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUpHospital.this, SignIn.class);
                startActivity(i);

            }
        });

    }
}
