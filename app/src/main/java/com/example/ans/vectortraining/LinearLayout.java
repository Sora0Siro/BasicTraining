package com.example.ans.vectortraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LinearLayout extends AppCompatActivity
{
    TextView resultText;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        TextView name = (TextView)findViewById(R.id.name);
        TextView surname = (TextView)findViewById(R.id.surname);
        TextView email = (TextView)findViewById(R.id.email);

        Intent intent = getIntent();
        String sName = intent.getStringExtra("name");
        String sSurname = intent.getStringExtra("surname");
        String sEmail = intent.getStringExtra("email");

        name.setText(sName);
        surname.setText(sSurname);
        email.setText(sEmail);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGr) ;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resultText = (TextView)findViewById(R.id.resultText);
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
                    intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                    break;
                }
                else if(newX<oldX)
                {
                    intent = new Intent(this,FullImageView.class);
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
}