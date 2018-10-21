package com.example.ans.vectortraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class FullImageView extends AppCompatActivity
{
    TextView textView;
    SeekBar seekBar;

    public final int MENU_QUIT_ID = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.seekText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //textView.setText(String.valueOf(progress)); 1 - значение
                textView.setText(String.valueOf(seekBar.getProgress())); // n - раз обновится
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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