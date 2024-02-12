package com.example.bloodup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class HospitalDatabase extends SQLiteOpenHelper{
    private static String databaseName = "hospitalDatabase";
    SQLiteDatabase hospitalDatabase;
    public HospitalDatabase(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table hospital(id integer primary key, " +
                "name text," +
                "phone integer," +
                "email text," +
                "password text," +
                "location text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists hospital");
        onCreate(sqLiteDatabase);
    }

    public void createNewHospital(String name, int phone, String email, String password, String location) {
        ContentValues row = new ContentValues();
        row.put("name", name);
        row.put("phone", phone);
        row.put("email", email);
        row.put("password", password);
        row.put("location", location);
        hospitalDatabase = getWritableDatabase();
        hospitalDatabase.insert("hospital", null, row);
        hospitalDatabase.close();
    }
    // delete all hospital from the hospital database
    void deleteData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from hospital");
    }
    // check if the email & password exist on the hospital database
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from hospital where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}