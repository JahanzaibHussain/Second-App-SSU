package com.jahanzaib.app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numOfCoffees = 0;

    /*TextView price = (TextView) findViewById(R.id.price);
    TextView quantity = (TextView) findViewById(R.id.quantity);
    Button inc  = (Button) findViewById(R.id.inc);
    Button dec = (Button) findViewById(R.id.dec);
    Button order = (Button) findViewById(R.id.order);
*/


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
            display(numOfCoffees);
        }
/*

        display(numOfCoffees);
        if (0 == numOfCoffees ){
            numOfCoffees = 0;
            display(numOfCoffees);
        }
*/
    }

    public void submitOrder(View view){
        display(numOfCoffees);
        displayPrice( numOfCoffees * 6);
    }

    public void display(int num){
        TextView quantity = (TextView) findViewById(R.id.quantities);
        quantity.setText("" + num);
    }

    public void displayPrice(int num){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(NumberFormat.getCurrencyInstance().format(num));
    }
}
