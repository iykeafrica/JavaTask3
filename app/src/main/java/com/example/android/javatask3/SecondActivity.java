package com.example.android.javatask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView, textView2, textView3;
    ImageView imageView;

    String groceriesFruits;
    String groceriesPrices;
    int groceriesTotal;
    String strTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();

        groceriesFruits = intent.getStringExtra("fruits");
        groceriesPrices = intent.getStringExtra("prices");
        groceriesTotal = intent.getIntExtra("total", 0);

        strTotal = String.valueOf(groceriesTotal);

        textView.setText(groceriesFruits);
        textView2.setText(groceriesPrices);
        textView3.setText(strTotal);

        imageView  = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                String shareBody = ("Fruit Ordered \n" + groceriesFruits + "\n") + ("Prices \n" + groceriesPrices + "\n") + ("Total \n" + strTotal) + "\n";
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ikechiucheagwu@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(emailIntent, "Share using"));

            }
        });
    }
}
