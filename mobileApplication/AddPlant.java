package com.example.steve.plantpals;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
Steven Nash
AddPlant:
    Activity that allows the user to add a plant to their plant list and send it to the server
 */
public class AddPlant extends Activity implements View.OnClickListener {
    Plant newPlant;
    private EditText n, m;
    String plantName;
    int plantMoisture;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        // Initialize the button and text fields
        btnClick = (Button) findViewById(R.id.button);
        btnClick.setOnClickListener(this);
        n = (EditText) findViewById(R.id.editPlantName);
        m = (EditText) findViewById(R.id.editMoisture);

    }

    // Commands executed on button press
    public void onClick(View view) {
        int plantNum;
        // Keep track of which plant is being added
        if(LocalStorage.plantList.isEmpty())
            plantNum = 1;
        else
            plantNum = LocalStorage.plantList.size()+1;


        // Add default values to the plant's parameters in case the text fields are left blank
        String s = m.getText().toString();
        if(s == null || s.isEmpty())
            s = "0";
        plantMoisture = Integer.parseInt(s);
        plantName = n.getText().toString();
        if(plantName == null || plantName.isEmpty())
            plantName = "New Plant " + Integer.toString(plantNum);
        // Create a new plant with the specified name and ideal moisture
        newPlant = new Plant(plantName, plantMoisture);
        // Add that plant to the array list
        LocalStorage.plantList.add(newPlant);

        // Update user's plant list and send to server
        new sendData().execute(Integer.toString(LocalStorage.plantList.size()-1));

        // Start the MyPlants activity
        Intent i = new Intent(AddPlant.this, MyPlants.class);
        startActivity(i);

    }
}
