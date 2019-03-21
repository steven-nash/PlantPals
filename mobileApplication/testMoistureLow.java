package com.example.steve.plantpals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
Steven Nash 
testMoistureLow:
    Send a test plant at position 1 that needs to be watered to test the system's response
 */
public class testMoistureLow extends AppCompatActivity {

    private TextView lowTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_moisture_low);

        lowTest = (TextView) findViewById(R.id.textLowTest);
        // Create the test plant
        Plant testPlant = new Plant("testPlant", 500);
        LocalStorage.plantList.add(0, testPlant);
        // Send the test plant to the server
        new sendData().execute("0");

    }
}
