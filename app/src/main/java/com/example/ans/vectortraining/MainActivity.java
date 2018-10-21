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

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName;
    EditText editText1Surname;
    EditText editText2Email;
    Button button;
    Button buttonClear;

    final int MENU_ITEM_MAIN = 1;
    final int MENU_ITEM_RPOFILE = 2;
    final int MENU_ITEM_OPTIONS = 3;
    final int MENU_ITEM_INFO = 4;
    final int MENU_ITEM_SPLSH = 5;

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private Vector<String> vectorTrain = new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText)findViewById(R.id.editText);
        editText1Surname = (EditText)findViewById(R.id.editText2);
        editText2Email = (EditText) findViewById(R.id.editText3);

        button = (Button)findViewById(R.id.button);
        buttonClear = (Button)findViewById(R.id.btt_Clear);

        button.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button:
                //Toast.makeText(this,"You have click the Button",Toast.LENGTH_SHORT).show(); - тост фуу >.<
                Intent intent = new Intent(this,ContextMenuTrain.class);
                String name = editTextName.getText().toString();
                String surname = editText1Surname.getText().toString();
                String email = editText2Email.getText().toString();

                sendStringToActivity(name,surname,email,intent);

                startActivity(intent);
                break;
            case R.id.btt_Clear:
                Toast.makeText(this,"You have click the Clear button",Toast.LENGTH_SHORT).show();
                editTextName.setText("");
                editText1Surname.setText("");
                editText2Email.setText("");
                break;
        }
    }

    private void sendStringToActivity(String name,String surname,String email,Intent intent)
    {
        intent.putExtra("name",name);
        intent.putExtra("surname",surname);
        intent.putExtra("email",email);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Main");
        menu.add(0,MENU_ITEM_MAIN,0,"Main");
        menu.add(0,MENU_ITEM_RPOFILE,0,"Profile");
        menu.add(0,MENU_ITEM_OPTIONS,0,"Options");
        menu.add(0,MENU_ITEM_INFO,0,"Info");
        menu.add(0,MENU_ITEM_SPLSH,0,"splash Test Activity");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            /*case MENU_ITEM_MAIN:
                // do whatever
                break;
            case MENU_ITEM_RPOFILE:
                // do whatever
                break;
            case MENU_ITEM_OPTIONS:
                // do whatever
                break;
            case MENU_ITEM_INFO:
                // do whatever
                break;*/
            case MENU_ITEM_SPLSH:
                Intent intent = new Intent(this,rotationTrai.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}