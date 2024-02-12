package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HospitalHomepage extends AppCompatActivity {
    private TextView findADonor, seeAllDonors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_homepage);
        findADonor = findViewById(R.id.findADonor);
        findADonor();
        seeAllDonors = findViewById(R.id.seeAllDonors);
        seeAllDonors();
    }
    // next activity
    private void findADonor() {
        findADonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HospitalHomepage.this, DonorCriteria.class);
                startActivity(intent);
            }
        });
    }
    // next activity
    private void seeAllDonors() {
        seeAllDonors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HospitalHomepage.this, Donors.class);
                startActivity(intent);
            }
        });

    }
}
