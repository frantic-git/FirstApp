package com.frantic.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    CheckBox checkBox;
    Button bOk;
    Button bCancel;
    Button bOut;

    private static final String tag = "frantic_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Vedroid Update");

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(true);

        bOk = (Button) findViewById(R.id.button4);
        bCancel = (Button) findViewById(R.id.button3);
        bOut = (Button) findViewById(R.id.button2);
        bOut.setBackgroundResource(R.color.llBottomColor);


        bOk.setOnClickListener(this);
        bOut.setOnClickListener(this);

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag,"нажал Cancel");
                Toast.makeText(getBaseContext(),"Нажал Cancel", Toast.LENGTH_SHORT ).show();
                textView.setText("push Cancel");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, !checkBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                Log.d(tag,"нажал OK");
                Toast.makeText(this,"Нажал OK", Toast.LENGTH_SHORT ).show();
                textView.setText("push OK");
                break;
            case R.id.button2:
                Log.d(tag,"нажал Out");
                Toast.makeText(this,"Нажал Out", Toast.LENGTH_SHORT ).show();
                textView.setText("push Out");
                break;
        }
    }

    public void onClickStart(View v){
        textView.setText("Vedroid Forefer!");
    }
}
