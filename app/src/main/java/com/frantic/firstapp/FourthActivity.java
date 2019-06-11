package com.frantic.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    private String firstName, lastName;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(this);

        Intent intent = getIntent();

        firstName = intent.getStringExtra("firstName");
        lastName = intent.getStringExtra("lastName");

        stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(lastName);

        TextView tvTime = (TextView) findViewById(R.id.textView5);
        tvTime.setText(stringBuilder.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button7:
                Intent intent = new Intent();
                intent.putExtra("name", stringBuilder.toString());
                setResult(RESULT_OK, intent);
                finish();
        }
    }
}
