package com.example.ans.vectortraining;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContextMenuTrain extends AppCompatActivity
{
    public final int MENU_QUIT_ID = 10;
    TextView tvColor, tvSize;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_train);

        tvColor = findViewById(R.id.textView);
        tvSize = findViewById(R.id.textView2);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo mInfo)
    {
        switch(view.getId())
        {
            case R.id.textView:
                menu.add(0,MENU_COLOR_RED,0,"Red");
                menu.add(0,MENU_COLOR_GREEN,0,"Green");
                menu.add(0,MENU_COLOR_BLUE,0,"Blue");
                break;
            case R.id.textView2:
                menu.add(0,MENU_SIZE_22,0,"22");
                menu.add(0,MENU_SIZE_26,0,"26");
                menu.add(0,MENU_SIZE_30,0,"30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
            // пункты меню для tvSize
            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
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
                //ыход из приложения
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
