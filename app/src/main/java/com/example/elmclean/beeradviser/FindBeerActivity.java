package com.example.elmclean.beeradviser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_MESSAGE)) {
            String messageText = intent.getStringExtra(EXTRA_MESSAGE);

            TextView messageView = (TextView)findViewById(R.id.message2);
            messageView.setText(messageText);
        }
    }

    // Call when button is clicked
    public void onClickFindBeer(View view) {
        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get selected line item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        BeerExpert expert = new BeerExpert();

        // Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        // String zippydee = new BigInteger(130, random).toString(32);

        // Display beers
        // brands.setText(beerType);
        brands.setText(brandsFormatted);
    }

    // Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {
        EditText messageView = (EditText)findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
}


