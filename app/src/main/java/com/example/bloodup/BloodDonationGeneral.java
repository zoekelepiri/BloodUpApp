package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BloodDonationGeneral extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_general);


    }
    // previous activity
    public void backButton(View view) {
        Intent intent=new Intent(this,BloodDonation.class);
        startActivity(intent);
    }
}
