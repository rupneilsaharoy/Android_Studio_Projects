package com.example.textfieldslogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view) {

        EditText usernameEditText = (EditText) findViewById(R.id.usernameeditTextTextPersonName);

        EditText passwordEditText = (EditText) findViewById(R.id.passwordeditTextTextPassword);

        Log.i("Info", "Button Pressed");

        Log.i("Username", usernameEditText.getText().toString());

        Log.i("Password", passwordEditText.getText().toString());

        Toast.makeText(this, "Hi there!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}