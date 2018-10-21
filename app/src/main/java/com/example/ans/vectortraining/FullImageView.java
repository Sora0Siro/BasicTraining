package com.example.ans.vectortraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class FullImageView extends AppCompatActivity
{
    TextView textView;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.seekText);

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
}
