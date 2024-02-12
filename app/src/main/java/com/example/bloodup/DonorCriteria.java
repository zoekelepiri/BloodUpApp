package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DonorCriteria extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_criteria);

        final Spinner bloodType = (Spinner)findViewById(R.id.BloodTypeSpinner);
        final Spinner location = (Spinner)findViewById(R.id.LocationSpinnerHospitalHome);


        Button findDonor = (Button)findViewById(R.id.findDonorBtn);

        // donor button in order to go to next activity, pushing also location & blood type on this
        findDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DonorCriteria.this, DonorsResults.class);
                i.putExtra("bloodType", bloodType.getSelectedItem().toString());
                i.putExtra("location", location.getSelectedItem().toString());
                startActivity(i);
            }
        });

    }

}
