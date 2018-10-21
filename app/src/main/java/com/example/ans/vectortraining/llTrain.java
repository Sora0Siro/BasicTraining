package com.example.ans.vectortraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class llTrain extends AppCompatActivity
{
    TextView resultText;
    Intent intent;

    public final int MENU_QUIT_ID = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        TextView name = findViewById(R.id.name);
        TextView surname = findViewById(R.id.surname);
        TextView email = findViewById(R.id.email);

        Intent intent = getIntent();
        String sName = intent.getStringExtra("name");
        String sSurname = intent.getStringExtra("surname");
        String sEmail = intent.getStringExtra("email");

        name.setText(sName);
        surname.setText(sSurname);
        email.setText(sEmail);

        RadioGroup radioGroup = findViewById(R.id.radioGr) ;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                resultText = findViewById(R.id.resultText);
                switch(checkedId)
                {
                    case R.id.rdName:
                        resultText.setText("Name");
                        break;
                    case R.id.rdSurname:
                        resultText.setText("Surname");
                        break;
                    case R.id.rdEmail:
                        resultText.setText("Email");
                        break;
                    case R.id.rdNull:
                        resultText.setText("nully");
                        break;
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        float oldX = 0;
        float newX = 0;

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                oldX = event.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                newX = event.getX();
                if(newX>oldX)
                {
                    intent = new Intent(llTrain.this,MainActivity.class);
                    startActivity(intent);
                    break;
                }
                else if(newX<oldX)
                {
                    intent = new Intent(llTrain.this,FullImageView.class);
                    startActivity(intent);
                    break;
                }
                break;
            }
            default:
                break;
        }
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0,MENU_QUIT_ID,0,"Return");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MENU_QUIT_ID:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}