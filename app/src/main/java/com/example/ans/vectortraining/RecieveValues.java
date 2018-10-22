package com.example.ans.vectortraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveValues extends AppCompatActivity
{
    String someName;
    String someCompany;
    int someInt;

    TextView compName;
    TextView compComp;
    TextView compPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_values);

        Bundle arguments = getIntent().getExtras();
        final Product product;
        if(arguments!=null)
        {
            product = (Product)arguments.getSerializable(Product.class.getSimpleName());

            someInt = product.getPrice();
            someName= product.getName();
            someCompany = product.getCompany();
        }

        /*someStr = arguments.get("1").toString();
        someObj = arguments.get("1");
        someDouble = arguments.getDouble("1");
        someFloat = arguments.getFloat("1");*/
    }
}
