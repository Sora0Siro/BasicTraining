package com.example.ans.vectortraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText editTextName;
    EditText editText1Surname;
    EditText editText2Email;
    Button button;
    Button buttonClear;

    final int MENU_ITEM_CALC = 1;
    final int MENU_ITEM_CONTMENU = 2;
    final int MENU_ITEM_IMAGE = 3;
    final int MENU_ITEM_LL = 4;
    final int MENU_ITEM_SPLSH = 5;

    public final int MENU_QUIT_ID = 10;

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText);
        editText1Surname = findViewById(R.id.editText2);
        editText2Email = findViewById(R.id.editText3);

        button = findViewById(R.id.Send);
        buttonClear = findViewById(R.id.btt_Clear);

        button.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    public void setExtras()
    {
        Intent intent = new Intent(this,ContextMenuTrain.class);
        String name = editTextName.getText().toString();
        String surname = editText1Surname.getText().toString();
        String email = editText2Email.getText().toString();

        intent.putExtra("name",name);
        intent.putExtra("surname",surname);
        intent.putExtra("email",email);

        startActivity(intent);
    }

    public void clearTextFields()
    {
        Toast.makeText(this,"You have click the Clear button",Toast.LENGTH_SHORT).show();
        editTextName.setText("");
        editText1Surname.setText("");
        editText2Email.setText("");
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.Send:
                //Toast.makeText(this,"You have click the Button",Toast.LENGTH_SHORT).show(); - тост фуу >.<
                setExtras();
                break;
            case R.id.btt_Clear:
                clearTextFields();
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0,MENU_ITEM_CALC,0,"Calculator");
        menu.add(0,MENU_ITEM_CONTMENU,0,"Context Menu");
        menu.add(0,MENU_ITEM_IMAGE,0,"Image View");
        menu.add(0,MENU_ITEM_LL,0,"Layout|:Linear");
        menu.add(0,MENU_ITEM_SPLSH,0,"Animations");

        menu.add(0,MENU_QUIT_ID,0,"Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case MENU_ITEM_CALC:
                intent = new Intent(MainActivity.this,Calculator.class);
                startActivity(intent);
                break;
            case MENU_ITEM_CONTMENU:
                intent = new Intent(MainActivity.this,ContextMenuTrain.class);
                startActivity(intent);
                break;
            case MENU_ITEM_IMAGE:
                intent = new Intent(MainActivity.this,FullImageView.class);
                startActivity(intent);
                break;
            case MENU_ITEM_LL:
                intent = new Intent(MainActivity.this,llTrain.class);
                startActivity(intent);
                break;
            case MENU_ITEM_SPLSH:
                intent = new Intent(MainActivity.this,rotationTrai.class);
                startActivity(intent);
                break;
            case MENU_QUIT_ID:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}