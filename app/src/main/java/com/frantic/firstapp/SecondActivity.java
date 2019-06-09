package com.frantic.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private static final String tag = "frantic_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(tag, "SecondActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "SecondActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "SecondActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "SecondActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "SecondActivity: onDestroy()");
    }
}
