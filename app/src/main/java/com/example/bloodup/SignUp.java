package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_donor_page);
        signUpButton = findViewById(R.id.signup_buttonDonor);

        final DonorDatabase donorDatabase = new DonorDatabase(this);

        EditText name = (EditText)findViewById(R.id.signup_name);
        EditText password = (EditText)findViewById(R.id.signup_password);
        final EditText phone = (EditText)findViewById(R.id.signup_phone);
        final EditText age = (EditText)findViewById(R.id.signup_age);
        final EditText email = (EditText)findViewById(R.id.signup_email);

        final Spinner location = (Spinner)findViewById(R.id.LocationSpinnerDonorRegister);

        final RadioGroup gender = (RadioGroup)findViewById(R.id.GenderRadioGroup);
        final String[] donorGender = {null};

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.MaleButton:
                        donorGender[0] = "Male";
                        break;
                    case R.id.FemaleButton:
                        donorGender[0] = "Female";
                        break;
                }
            }
        });
        signUpButton.setOnClickListener(v -> {
            // Check if the fields have value
            if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()|| phone.getText().toString().isEmpty() || age.getText().toString().isEmpty() || email.getText().toString().isEmpty() || donorGender[0] == null)
            {
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // create the donor in the datebase with all info which the user has added on fields
                // redirect the user in the next activity with 'pushing' the name of the donor
               donorDatabase.createADonor(name.getText().toString(),
                        password.getText().toString(),
                        donorGender[0],
                        Integer.parseInt(phone.getText().toString()),
                        Integer.parseInt(age.getText().toString()),
                        email.getText().toString(),
                        location.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(), "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                // next activity
                Intent i = new Intent(SignUp.this, SignUpDonorDetails.class);
                i.putExtra("donorName", name.getText().toString());
                startActivity(i);
                // empty the edit texts
                name.getText().clear();
                phone.getText().clear();
                age.getText().clear();
                email.getText().clear();
            }
        });

    }
}
