package com.example.android.javatask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> fruits = new ArrayList<String>();
    ArrayList<String> prices = new ArrayList<String>();

    int a = 0;
    int b = 0;
    int d = 0;
    int f = 0;
    int h = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selected(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.orange:
                if (checked) {
                    fruits.add("Orange");
                    prices.add("₦1000");
                    a = 1000;
                } else {
                    fruits.remove("Orange");
                    prices.remove("₦1000");
                    a = 0;
                }
                break;

            case R.id.apple:
                if (checked) {
                    fruits.add("Apple");
                    prices.add("₦3000");
                    b = 3000;
                } else {
                    fruits.remove("Apple");
                    prices.remove("₦3000");
                    b = 0;
                }
                break;

            case R.id.cashew:
                if (checked) {
                    fruits.add("Cashew");
                    prices.add("₦1500");
                    d = 1500;
                } else {
                    fruits.remove("Cashew");
                    prices.remove("₦1500");
                    d = 0;
                }
                break;

            case R.id.mango:
                if (checked) {
                    fruits.add("Mango");
                    prices.add("₦2000");
                    f = 2000;
                } else {
                    fruits.remove("Mango");
                    prices.remove("₦2000");
                    f = 0;
                }
                break;

            case R.id.guava:
                if (checked) {
                    fruits.add("Guava");
                    prices.add("₦1800");
                    h = 1800;
                } else {
                    fruits.remove("Guava");
                    prices.remove("₦1800");
                    h = 0;
                }
                break;
            default:

        }

    }

    public void choice(View view) {
        String fruitSelection = "";
        String priceSelection = "";
        int sum = a + b + d + f + h;


        for (String fruitSamples : fruits) {
            fruitSelection = fruitSelection + fruitSamples + "\n";
        }

        for (String priceSamples: prices) {
            priceSelection = priceSelection + priceSamples + "\n";
        }

        Intent intent = new Intent(MainActivity.this, com.example.android.javatask3.SecondActivity.class);

        intent.putExtra("fruits", fruitSelection);
        intent.putExtra("prices", priceSelection);
        intent.putExtra("total", sum);
        startActivity(intent);


    }
}
