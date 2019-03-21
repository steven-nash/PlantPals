package com.example.steve.plantpals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/*
Steven Nash 
MainActivity:
    Activity that welcomes the user on launch
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load any available plants from the server
        new receiveData().execute("172.20.10.6");

        // Initialize the check box that allows the user to enter test mode
        final CheckBox checkBox = (CheckBox) (findViewById(R.id.checkBox));

        // Initialize and set the button on screen to launch the MyPlants activity
        final Button plantBtn = (Button) (findViewById(R.id.plantButton));
        plantBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Set the global parameter test mode to true if the check box is selected
                if (checkBox.isChecked()) {
                    LocalStorage.testMode = true;
                }
                // Load data on button press as a fail-safe
                new receiveData().execute("172.20.10.6");
                // Launch the MyPlants activity
                startActivity(new Intent(MainActivity.this, MyPlants.class));
            }
        });
    }
}
