package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BloodDonationProcess extends AppCompatActivity {
    String[] Quote = {"If you’re donating whole blood, we’ll cleanse an area on your arm ",
            "insert a brand new sterile needle for the blood draw",
            "Other types of donations, such as platelets, are made using an apheresis machine which will be connected to both arms.",
            "A whole blood donation takes about 8-10 minutes",
            "The donation is complete and a staff person will place a bandage on your arm.",
            "The apheresis machine will collect a small amount of blood",
            "Remove the platelets, and return the rest of the blood through your other arm",
            "This cycle will be repeated several times over about 2 hours"};
    ListView lView;
    BloodListAdapter lAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_process);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Attach the adapter to a ListView
        lView = (ListView) findViewById(R.id.bloodDonationProcess);
        lAdapter = new BloodListAdapter(BloodDonationProcess.this, Quote);
        lView.setAdapter(lAdapter);
    }
    // previous activity
    public void backButton(View view) {
        Intent intent=new Intent(this,BloodDonation.class);
        startActivity(intent);
    }
}
