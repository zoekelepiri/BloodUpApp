package com.example.bloodup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BloodDonationAfterProcess extends AppCompatActivity {
    String[] Quote = {"After donating blood, you’ll have a snack and something to drink in the refreshment area.",
            "You’ll leave after 10-15 minutes and continue your normal routine.",
            "Enjoy the feeling of accomplishment knowing you are helping to save lives.",
            "Take a selfie, or simply share your good deed with friends. It may inspire them to become blood donors. ",
            "Learn something new every day"};
    ListView lView;
    BloodListAdapter lAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_after_process);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Attach the adapter to a ListView
        lView = (ListView) findViewById(R.id.bloodDonationAfterProcess);
        lAdapter = new BloodListAdapter(BloodDonationAfterProcess.this, Quote);
        lView.setAdapter(lAdapter);
    }
    // previous activity
    public void backButton(View view) {
        Intent intent=new Intent(this,BloodDonation.class);
        startActivity(intent);
    }
}

