package com.jahanzaib.app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    int numOfCoffees = 1;

    public void increment(View view){
        numOfCoffees = numOfCoffees + 1;
        display(numOfCoffees);
    }

    public void decrement(View view){
        numOfCoffees = numOfCoffees - 1;
        if ( numOfCoffees > 0){
            display(numOfCoffees);
        } else {
            numOfCoffees = 0;
            Toast.makeText(this, "You cannot have less then 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }

    public void submitOrder(View view){
        int base = numOfCoffees * 6;

        CheckBox cream = (CheckBox) findViewById(R.id.cream);
        boolean hasfullcream = cream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocholate);
        boolean hasfullchocolate = chocolate.isChecked();

        display(numOfCoffees);
        displayPrice( base, hasfullcream , hasfullchocolate);

    }

    public void display(int num){
        TextView quantity = (TextView) findViewById(R.id.quantities);
        quantity.setText("" + num);
    }

    public void displayPrice(int num , boolean addCream , boolean addChoco){
        TextView price = (TextView) findViewById(R.id.price);
        EditText name = (EditText) findViewById(R.id.name);
        String uname = name.getText().toString();

        String text = "Name: ";
        text += uname;
        text += "\nAdd cream? " + addCream;
        text += "\nAdd Chocolate? " + addChoco;
        text += "\nQuantity: " + numOfCoffees;
        text += "\nTotal: ";

        if(addCream == true && addChoco == true){
            price.setText(text + NumberFormat.getCurrencyInstance().format(num + 3 ) );
        }else if(addChoco == true){
            price.setText(text + NumberFormat.getCurrencyInstance().format(num + 2) );
        }else if (addCream == true){
            price.setText(text + NumberFormat.getCurrencyInstance().format(num + 1 ) );
        }
        else {
            price.setText(text + NumberFormat.getCurrencyInstance().format(num) + "\n Thank You!");
        }
    }
}
