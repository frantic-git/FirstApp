package com.frantic.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    TextView textView, textView2;
    CheckBox checkBox;
    Button bOk;
    Button bCancel;
    Button bOut;
    RadioGroup rgGravity;
    LinearLayout llMain;
    SeekBar seekBar;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    private static final String tag = "frantic_log";
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    LinearLayout.LayoutParams bOkParams;
    LinearLayout.LayoutParams bCancelParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Vedroid Update");

        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Anti-Vedroid");

        registerForContextMenu(textView);
        registerForContextMenu(textView2);

        llMain = (LinearLayout) findViewById(R.id.linearLayout);

        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);

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

        bOkParams = (LinearLayout.LayoutParams) bOk.getLayoutParams();
        bCancelParams = (LinearLayout.LayoutParams) bCancel.getLayoutParams();

        seekBar = (SeekBar) findViewById(R.id.sbWeight);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textView:
                Log.d(tag, "textview - 1");
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.textView2:
                Log.d(tag, "textview - 1");
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, !checkBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_delete:
                int count = llMain.getChildCount();
                if(count <= 2)break;
                else{
                    llMain.removeViewAt(count-1);
                }
                break;
            case R.id.menu_add:
                StringBuilder sb = new StringBuilder();
                sb.append("Menu item: ");
                sb.append("\r\n title: " + item.getTitle());
                Toast.makeText(this, sb.toString(),Toast.LENGTH_SHORT).show();

                int btnGravity = Gravity.LEFT;

                switch (rgGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }

                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent,wrapContent);
                lParams.gravity = btnGravity;

                Log.d(tag,"создаем кнопку");
                Button btnNew = new Button(this);
                btnNew.setText(sb.toString());
                llMain.addView(btnNew, lParams);

                Log.d(tag,Integer.toString(llMain.getChildCount()));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case MENU_COLOR_BLUE:
                textView.setText("Color is BLUE");
                textView.setTextColor(Color.BLUE);
                break;
            case MENU_COLOR_GREEN:
                textView.setText("Color is GREEN");
                textView.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_RED:
                textView.setText("Color is RED");
                textView.setTextColor(Color.RED);
                break;
            case MENU_SIZE_22:
                textView.setText("Size is 22");
                textView.setTextSize(22);
                break;
            case MENU_SIZE_26:
                textView.setText("Size is 26");
                textView.setTextSize(26);
                break;
            case MENU_SIZE_30:
                textView.setText("Size is 30");
                textView.setTextSize(30);
                break;
        }

        return super.onContextItemSelected(item);
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int leftValue = progress;
        int rightValue = seekBar.getMax()-progress;

        bOkParams.weight = leftValue;
        bCancelParams.weight = rightValue;

        bOk.requestLayout();
        bCancel.requestLayout();

        bOk.setText(Integer.toString(leftValue));
        bCancel.setText(Integer.toString(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
