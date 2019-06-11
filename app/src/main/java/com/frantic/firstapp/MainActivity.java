package com.frantic.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    TextView textView, textView2, tvFirstName, tvLastName;
    CheckBox checkBox;
    Button bOk, bCancel, bOut, btn1, btn2;
    RadioGroup rgGravity;
    LinearLayout llMain;
    SeekBar seekBar;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    // константы для ID пунктов меню
    final int MENU_ALPHA_ID = 7;
    final int MENU_SCALE_ID = 8;
    final int MENU_TRANSLATE_ID = 9;
    final int MENU_ROTATE_ID = 10;
    final int MENU_COMBO_ID = 11;

    private static final String tag = "frantic_log";
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    LinearLayout.LayoutParams bOkParams;
    LinearLayout.LayoutParams bCancelParams;

    LinearLayout.LayoutParams btn1Params;
    LinearLayout.LayoutParams btn2Params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Vedroid Update");

        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Anti-Vedroid");

        tvFirstName = (TextView) findViewById(R.id.tvFirstName);
        tvLastName = (TextView) findViewById(R.id.tvLastName);

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

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

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
        btn1Params = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        btn2Params = (LinearLayout.LayoutParams) btn2.getLayoutParams();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

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

                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                menu.add(0, MENU_COMBO_ID, 0, "combo");
                break;
            case R.id.textView2:
                Log.d(tag, "textview - 1");
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
            case R.id.sbWeight:
                Log.d(tag, "seekbar menu");
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
            case R.id.menu_edit:
                finish();
                break;
            case R.id.menu_delete:
                int count = llMain.getChildCount();
                if(count <= 3)break;
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
        Animation anim = null;
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
            case MENU_ALPHA_ID:
                // создаем объект анимации из файла anim/myalpha
                anim = AnimationUtils.loadAnimation(this, R.anim.first_alpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.first_scale);
                break;
            case MENU_TRANSLATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.first_trans);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.first_rotate);
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.first_combo);
                break;
        }

        btn2.startAnimation(anim);

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
            case R.id.btn1:
                Log.d(tag, "Нажата кнопка btn1");
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                switch (rgGravity.getCheckedRadioButtonId()){
                    case  R.id.rbLeft:
                        Log.d(tag, "Нажата кнопка btn2 и выбран left action");
                        Intent intentShowLeft = new Intent("com.frantic.firstapp.showleft");
                        intentShowLeft.putExtra("firstName", tvFirstName.getText().toString());
                        intentShowLeft.putExtra("lastName", tvLastName.getText().toString());
                        startActivity(intentShowLeft);
                        break;
                    case R.id.rbRight:
                        Log.d(tag, "Нажата кнопка btn2 и выбран right action");
                        Intent intentShowRight = new Intent("com.frantic.firstapp.showright");
                        startActivity(intentShowRight);
                        break;
                    case R.id.rbCenter:
                        Intent intentShowCenter = new Intent(this, FourthActivity.class);
                        intentShowCenter.putExtra("firstName", tvFirstName.getText().toString());
                        intentShowCenter.putExtra("lastName", tvLastName.getText().toString());
                        //startActivity(intentShowCenter);
                        startActivityForResult(intentShowCenter, 1);
                }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null)return;
        String name = data.getStringExtra("name");
        textView.setText("Your name is " + name);
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

        btn1Params.weight = leftValue;
        btn2Params.weight = rightValue;

        bOk.requestLayout();
        bCancel.requestLayout();

        btn1.requestLayout();
        btn2.requestLayout();

        bOk.setText(Integer.toString(leftValue));
        bCancel.setText(Integer.toString(rightValue));

        btn1.setText(Integer.toString(leftValue));
        btn2.setText(Integer.toString(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
