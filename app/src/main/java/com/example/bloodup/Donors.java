package com.example.bloodup;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Donors extends AppCompatActivity {
    ListView viewAllList;
    ArrayAdapter<String> viewAllAdapter;
    DonorDatabase donorDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_donors);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set home slc
        bottomNavigationView.setSelectedItemId(R.id.allDonors);

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
                        startActivity(new Intent(getApplicationContext(), DonorCriteria.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.allDonors:
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
        viewAllList = (ListView)findViewById(R.id.AllDonorsList);
        viewAllAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        viewAllList.setAdapter(viewAllAdapter);

        // create the donor database
       donorDatabase = new DonorDatabase(getApplicationContext());

        // take the whole donors from the database
        Cursor cursor = donorDatabase.seeAllDonors();
        // take the values of the database
        while (!cursor.isAfterLast())
        {
            viewAllAdapter.add(cursor.getString(1));
            cursor.moveToNext();
        }
        // Check if exist donors on the database
        // if not toast message printing
        if (viewAllAdapter.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "No Donors to Show", Toast.LENGTH_SHORT).show();
        }

        //Gets donor data
        viewAllList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String diabetic = "Diabetic: ";
                String highBloodPressure = "High Blood Pressure: ";
                String gender = "Gender: ";
                String phone = "Phone: ";
                String age = "Age: ";
                String email = "Email: ";
                String location = "Location: ";
                String bloodType = "Blood Type: ";
                Intent intent = new Intent(Donors.this, DonorsInfo.class);
                intent.putExtra("gender", gender.concat(donorDatabase.getDonorGender(((TextView) view).getText().toString())));
                intent.putExtra("phone", phone.concat(donorDatabase.getDonorPhone(((TextView) view).getText().toString())));
                intent.putExtra("age", age.concat(donorDatabase.getDonorAge(((TextView) view).getText().toString())));
                intent.putExtra("email", email.concat(donorDatabase.getDonorEmail(((TextView) view).getText().toString())));
                intent.putExtra("location", location.concat(donorDatabase.getDonorLocation(((TextView) view).getText().toString())));
                intent.putExtra("diabetic", diabetic.concat(donorDatabase.getDonorIsDiabetic(((TextView) view).getText().toString())));
                intent.putExtra("bloodPressure", highBloodPressure.concat(donorDatabase.getDonorIsHighBloodPressure(((TextView) view).getText().toString())));
                intent.putExtra("bloodType", bloodType.concat(donorDatabase.getDonorBloodType(((TextView) view).getText().toString())));
                startActivity(intent);




            }
        });
    }
}
