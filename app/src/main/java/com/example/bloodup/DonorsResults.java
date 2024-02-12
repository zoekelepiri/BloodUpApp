package com.example.bloodup;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DonorsResults extends AppCompatActivity {
    ListView viewList;
    ArrayAdapter<String> viewAdapter;
    DonorDatabase donorDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_donors);
        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set home slc
        bottomNavigationView.setSelectedItemId(R.id.donor);

        //item listener, click on navigation bar's button and move to another class
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.donor:
                        return true;
                    case R.id.allDonors:
                        startActivity(new Intent(getApplicationContext(), Donors.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), SettingsHospital.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        // Attach the adapter to a ListView
        viewList = (ListView) findViewById(R.id.AllDonorsList);
        viewAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        viewList.setAdapter(viewAdapter);
        // create the database
        donorDatabase = new DonorDatabase(getApplicationContext());
        // get the value from Donors activity which have been selected
        String bloodTypeExtra = getIntent().getExtras().getString("bloodType");
        String locationExtra = getIntent().getExtras().getString("location");

        // take the donor from the database
        Cursor cursor = donorDatabase.seeAllDonors();
        // take the values which have the preferable values (location & bloodType)
        while (!cursor.isAfterLast()) {
            if (locationExtra.equals(cursor.getString(6)) &&
                    bloodTypeExtra.equals(cursor.getString(9))) {
                viewAdapter.add(cursor.getString(1));
            }
            cursor.moveToNext();
        }
        // if does not exist donors with this criteria
        if (viewAdapter.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No Donors to Show", Toast.LENGTH_SHORT).show();
        }


        // in case of having donors with the preferable location & bloodType
        // clickable each item, getting the phone of user in case of calling
        viewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phone = donorDatabase.getDonorPhone(((TextView) view).getText().toString());
                Uri number = Uri.parse("tel:" + phone);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);

            }
        });


    }
}
