package com.example.ans.vectortraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener
{
    private final static String TAG = "MainActivity";
    //из int 100 в dip
    int textViewHeight = 100;
    int testV = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,textViewHeight,getResources().getDisplayMetrics());

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        Log.d(TAG, "onCreate");

    }

    @Override
    public void onClick(View v)
    {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if(TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) return;

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch(v.getId())
        {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
                default:
                    break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);

        Log.d(TAG,"onClick");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0,MENU_RESET_ID,0,"Reset");
        menu.add(0,MENU_QUIT_ID,0,"Return");

        Log.d(TAG,"onCreateOptionsMenu");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                //ыход из приложения
                finish();
                break;
        }

        Log.d(TAG,"onOptionsItemSelected");

        return super.onOptionsItemSelected(item);
    }
}