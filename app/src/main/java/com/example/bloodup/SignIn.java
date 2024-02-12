package com.example.bloodup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    TextView signUpRedirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button signInButton;

        final HospitalDatabase hospitalDatabase = new HospitalDatabase(this);
        final DonorDatabase donorDatabase = new DonorDatabase(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);
        signInButton = findViewById((R.id.login_button));
        signUpRedirectText = findViewById((R.id.signupRedirectText));
        //When click the button check if the donor or hospital exist on the database
        // logs with toast message the corresponding messages and redirect the user to the next activity
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = findViewById(R.id.login_email);
                EditText password = findViewById(R.id.login_password);
                if(email.getText().toString().equals("")||password.getText().toString().equals("")) {
                    Toast.makeText(SignIn.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkCredentialsDonor = donorDatabase.checkEmailPassword(email.getText().toString(), password.getText().toString());
                    Boolean checkCredentialsHospital = hospitalDatabase.checkEmailPassword(email.getText().toString(), password.getText().toString());
                    System.out.println(checkCredentialsDonor);
                    if (checkCredentialsDonor) {
                        Toast.makeText(SignIn.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), BloodDonation.class);
                        startActivity(intent);
                    } else if (checkCredentialsHospital){
                        Toast.makeText(SignIn.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HospitalHomepage.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(SignIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // if the user is not on the databases, sign up
        signUpRedirect();

    }
    // redirect to welcome page in order to create a new account
    private void signUpRedirect() {
        signUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, WelcomePage.class);
                startActivity(intent);
            }
        });

    }
}