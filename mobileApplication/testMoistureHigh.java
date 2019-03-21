package com.example.steve.plantpals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
Steven Nash 
testMoistureHigh:
    Send a plant to the server at position 1 that tests the server's response when the plant
    does not need to be watered
 */
public class testMoistureHigh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_moisture_high);

        // Create the test plant
        Plant testPlant = new Plant("testPlant", 0);
        LocalStorage.plantList.add(0, testPlant);
        // Send the data to the server
        new sendData().execute("0");

    }
}
