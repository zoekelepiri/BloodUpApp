package com.example.bloodup;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DonorsInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors_info);
        final TextView genderResult = (TextView)findViewById(R.id.GenderResultTxt);
        final TextView phoneResult = (TextView)findViewById(R.id.PhoneResultTxt);
        final TextView ageResult = (TextView)findViewById(R.id.AgeResultTxt);
        final TextView emailResult = (TextView)findViewById(R.id.EmailResultTxt);
        final TextView locationResult = (TextView)findViewById(R.id.LocationResultTxt);
        final TextView diabeticResult = (TextView)findViewById(R.id.DiabeticResultTxt);
        final TextView highBloodPressureResult = (TextView)findViewById(R.id.BloodPressureResultTxt);
        final TextView bloodTypeResult = (TextView)findViewById(R.id.BloodTypeResultTxt);

        // get the values which Donors activity "send"
        String gender = getIntent().getStringExtra("gender");
        String phone = getIntent().getStringExtra("phone");
        String age = getIntent().getStringExtra("age");
        String email = getIntent().getStringExtra("email");
        String location = getIntent().getStringExtra("location");
        String diabetic = getIntent().getStringExtra("diabetic");
        String bloodPressure = getIntent().getStringExtra("bloodPressure");
        String bloodType = getIntent().getStringExtra("bloodType");

        // set value on each textView
        genderResult.setText(gender);
        phoneResult.setText(phone);
        ageResult.setText(age);
        emailResult.setText(email);
        locationResult.setText(location);
        diabeticResult.setText(diabetic);
        highBloodPressureResult.setText(bloodPressure);
        bloodTypeResult.setText(bloodType);
    }

}
