package com.example.bloodup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpDonorDetails extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_details);
        Button signUpButton = (Button)findViewById(R.id.signup_donor_details_button);
        final DonorDatabase donorDatabase = new DonorDatabase(this);


        String donorName = getIntent().getExtras().getString("donorName");
        final Spinner bloodType = (Spinner)findViewById(R.id.BloodTypeSpinner2);
        final RadioGroup diabetic = (RadioGroup)findViewById(R.id.diabeticRadioGroup);
        final String[] diabeticResult = {null};
        diabetic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.isDiabetic:
                        diabeticResult[0] = "Yes";
                        break;
                    case R.id.isNotDiabetic:
                        diabeticResult[0] = "No";
                        break;
                }
            }
        });

        final RadioGroup bloodPressure = (RadioGroup)findViewById(R.id.pressureRadioGroup);
        final String[] bloodPressureResult = {null};
        bloodPressure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.hasBloodPressure:
                        bloodPressureResult[0] = "Yes";
                        break;
                    case R.id.hasNotBloodPressure:
                        bloodPressureResult[0] = "No";
                        break;
                }
            }
        });


        signUpButton.setOnClickListener(v -> {
            // Check if the fields have not value
            if (diabeticResult[0] == null || bloodPressureResult[0] == null)
            {
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // update the information of the user corresponding their name and add it on the database
                donorDatabase.updateDonorInfo(
                        donorName,
                        diabeticResult[0],
                        bloodPressureResult[0],
                        bloodType.getSelectedItem().toString());
                // message to the user
                Toast.makeText(getApplicationContext(), "Your Data Stored Successfully!", Toast.LENGTH_SHORT).show();
                // next activity
                Intent i = new Intent(SignUpDonorDetails.this, SignIn.class);
                startActivity(i);
            }
        });

    }


}
