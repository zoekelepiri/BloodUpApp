package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BloodDonationList extends AppCompatActivity {
    String[] Quote = {"Age: You are aged between 18 and 65.",
            "Weight: You weigh at least 50 kg.",
            "You must be in good health at the time you donate.",
            "You cannot donate if you have a cold, flu, sore throat, cold sore, stomach bug or any other infection",
            "You must not donate blood If you do not meet the minimum haemoglobin level for blood donation",
            "If you have recently had a tattoo or body piercing you cannot donate for 6 months from the date of the procedure.",
            "Travel to areas where mosquito-borne infections are endemic",
            "It is not advisable to donate blood while breast-feeding.",
            "Have ever injected recreational drugs.",
            "If you engaged in “at risk” sexual activity in the past 12 months' ",
            "Wait eight weeks between whole blood donations",
            "Be in good general health",
            "Bring your ID"};
    ListView lView;
    BloodListAdapter lAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_can_give_blood);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Attach the adapter to a ListView
        lView = (ListView) findViewById(R.id.bloodDonationSharing);
        lAdapter = new BloodListAdapter(BloodDonationList.this, Quote);
        lView.setAdapter(lAdapter);
    }
    // previous activity
    public void back(View view) {
        Intent intent=new Intent(this,BloodDonation.class);
        startActivity(intent);
    }
}
