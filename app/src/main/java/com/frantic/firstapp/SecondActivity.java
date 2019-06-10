package com.frantic.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String tag = "frantic_log";
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(tag, "SecondActivity: onCreate()");

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        Intent intent = getIntent();
        String action = intent.getAction();

        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(lastName);

        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //String time = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvTime = (TextView) findViewById(R.id.textView3);
        tvTime.setText(stringBuilder.toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "MainActivity: onRestart()");
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

    @Override
    public void onClick(View v) {
        Log.d(tag, "зашел в OnClick на Second Activity");
        switch (v.getId()){
            case R.id.button5:
                Log.d(tag, "start third activity");
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
        }
    }
}
