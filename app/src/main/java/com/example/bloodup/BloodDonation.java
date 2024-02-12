package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BloodDonation extends AppCompatActivity {
    private TextView whoCanDonate;
    private TextView bloodDonationProcess, bloodDonationAfterProcess, bloodDonationGeneral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation_info);
        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set home slc
        bottomNavigationView.setSelectedItemId(R.id.info);

        //item listener, click on navigation bar's button and move to another class
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.info:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), SettingsDonors.class));
                        overridePendingTransition(0, 0);
                }
                return false;
            }
        });
        whoCanDonate = findViewById(R.id.whoCanDonate);
        whoCanDonateRedirect();
        bloodDonationProcess = findViewById(R.id.donationProcess);
        donationProcess();
        bloodDonationAfterProcess = findViewById(R.id.afterDonationProcess);
        bloodDonationAfterProcess();
        bloodDonationGeneral = findViewById(R.id.donationGeneralInfo);
        bloodDonationGeneral();



    }
    // when click on whoCanDonate text, redirect on the Blood DonationList activity
    private void whoCanDonateRedirect() {
        whoCanDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodDonation.this, BloodDonationList.class);
                startActivity(intent);
            }
        });
    }
    // when click on bloodDonationProcess text, redirect on the BloodDonationProcess activity
    private void donationProcess() {
        bloodDonationProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodDonation.this, BloodDonationProcess.class);
                startActivity(intent);
            }
        });
    }
    // when click on bloodDonationAfterProcess text, redirect on the BloodDonationAfterProcess activity
    private void bloodDonationAfterProcess(){
        bloodDonationAfterProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodDonation.this, BloodDonationAfterProcess.class);
                startActivity(intent);
            }
        });
    }
    // when click on bloodDonationGeneral text, redirect on the BloodDonationGeneral activity
    private void bloodDonationGeneral(){
        bloodDonationGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodDonation.this, BloodDonationGeneral.class);
                startActivity(intent);
            }
        });
    }


}
