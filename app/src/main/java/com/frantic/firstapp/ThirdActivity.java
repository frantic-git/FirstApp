package com.frantic.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThirdActivity extends AppCompatActivity {

    private static final String tag = "frantic_log";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d(tag, "ThirdActivity: onCreate()");

        Intent intent = getIntent();
        String action = intent.getAction();

        String format = "", textInfo = "";

        TextView tvTime = (TextView) findViewById(R.id.textView4);

        if(action.equals("com.frantic.firstapp.showleft")){
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }
        if(action.equals("com.frantic.firstapp.showright")){
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time = sdf.format(new Date(System.currentTimeMillis()));

        tvTime.setText(textInfo + time);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "ThirdActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "ThirdActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "ThirdActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "ThirdActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "ThirdActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "ThirdActivity: onDestroy()");
    }

}
