package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, year INT(4))");
            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rupneil', 25)");
            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rupneil', 43)");
            //sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Dave', 14)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Rupneil' AND age = 43", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToNext();

            while (!c.isAfterLast()) {
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("userResults - age", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}