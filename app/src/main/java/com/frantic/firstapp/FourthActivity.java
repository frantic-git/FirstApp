package com.frantic.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();

        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(lastName);

        TextView tvTime = (TextView) findViewById(R.id.textView5);
        tvTime.setText(stringBuilder.toString());

    }

    @Override
    public void onClick(View v) {

    }
}
