package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomePage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_or_hospital);

    }
    // on Click method which user goes to next activity
    public void donorChoice(View view) {
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }
    // on Click method which user goes to next activity
    public void hospitalChoice(View view) {
        Intent intent=new Intent(this,SignUpHospital.class);
        startActivity(intent);
    }
}
