package com.example.bloodup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonorDatabase extends SQLiteOpenHelper {
        private static String databaseName = "donorDatabase";
        SQLiteDatabase donorDatabase;

        public DonorDatabase( Context context) {
            super(context, databaseName, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table donor(id integer primary key, " +
                    "name text," +
                    "password text," +
                    "gender text," +
                    "phone integer," +
                    "age integer," +
                    "email text," +
                    "location text," +
                    "isDiabetic text," +
                    "isHighBloodPressure text," +
                    "bloodType text)"
            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists donor");
            onCreate(sqLiteDatabase);
        }
        public void createADonor(String name, String password, String gender, int phone, int age, String email, String location) {
            ContentValues row = new ContentValues();
            row.put("name", name);
            row.put("password", password);
            row.put("gender", gender);
            row.put("phone", phone);
            row.put("age", age);
            row.put("email", email);
            row.put("location", location);
            donorDatabase = getWritableDatabase();
            donorDatabase.insert("donor", null, row);
            donorDatabase.close();
        }
        public void updateDonorInfo(String name, String diabetic, String highPressure, String bloodType) {
            donorDatabase = getWritableDatabase();
            ContentValues row = new ContentValues();
            row.put("isDiabetic", diabetic);
            row.put("isHighBloodPressure", highPressure);
            row.put("bloodType", bloodType);
            donorDatabase.update("donor", row, "name like?", new String[]{name});
            donorDatabase.close();
        }
        //  // get method in order to have the gender of the donor
        public String getDonorGender(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select gender from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }

        // get method in order to have the age of the donor
        public String getDonorPhone(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select phone from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }

        //  // get method in order to have the age of the donor
        public String getDonorAge(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select age from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }

    // get method in order to have the email of the donor
        public String getDonorEmail(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select email from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }
    // get method in order to have location of the donor
        public String getDonorLocation(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select location from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }
    // get method in order to have diabetic value of the donor
        public String getDonorIsDiabetic(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select isDiabetic from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }

    // get method in order to have the blood pressure of the donor
        public String getDonorIsHighBloodPressure(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select isHighBloodPressure from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }

        // get method in order to have the blood type of the donor
        public String getDonorBloodType(String name)
        {
            donorDatabase = getReadableDatabase();
            String[] arg = {name};

            Cursor cursor = donorDatabase.rawQuery("Select bloodType from donor where name like ?", arg);
            cursor.moveToFirst();
            donorDatabase.close();
            return cursor.getString(0);
        }
        // see all the donors with personal information retrieved from the database
        public Cursor seeAllDonors() {
            donorDatabase = getReadableDatabase();
            String[] rowDetails = {"id", "name", "gender", "phone", "age", "email", "location", "isDiabetic", "isHighBloodPressure", "bloodType"};
            Cursor cursor = donorDatabase.query("donor", rowDetails, null, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();
            donorDatabase.close();
            return cursor;
        }
        // delete the whole data (donors) from the donor database
        void deleteData(){
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("delete from donor");
        }

        // check the existance of the email on the donor database
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ?", new String[]{email});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    // check if the password and email exist on the database
    // if exist true, else false
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from donor where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    }


