package com.example.steve.plantpals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/*
Steven Nash
MyPlants:
    Activity that allows the user to view and edit their plant list.
 */
public class MyPlants extends AppCompatActivity {
    // Initialize text fields
    private TextView showName, showMoisture, moistureLabel, noPlants;
    private EditText mockVal;
    // Keep a copy of the current plant on screen
    private Plant currentPlant;
    // Initialize a variable to keep count of which plant the user is viewing
    private int plantCnt = 0;

    // Commands performed as the MyPlants activity is started
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants2);

        // Button to add a new plant
        final Button addBtn = (Button)(findViewById(R.id.add_plant_button));
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start the AddPlant activity when this button is pressed
                startActivity(new Intent(MyPlants.this, AddPlant.class));
            }
        });
        // If there is more than one plant in the plant list, make the add button invisible
        if(LocalStorage.plantList.size() > 1)
            addBtn.setVisibility(View.INVISIBLE);

        // This is a button that allows you to delete the currently viewed plant.
        // Unfortunately, the server side of the project could not support such a function.
        final Button deleteBtn = (Button) (findViewById(R.id.deleteButton));
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Remove the current plant from the PlantList, restart the MyPlants activity
                LocalStorage.plantList.remove(plantCnt);
                startActivity(new Intent(MyPlants.this, MyPlants.class));
            }
        });
        //if(LocalStorage.plantList.size() < 1)
        // The button is set to invisible indefinitely, unless my colleagues add this functionality in the server side.
        deleteBtn.setVisibility(View.INVISIBLE);

        // This button allows the user to return to the homepage from the MyPlants activity
        Button home = (Button)(findViewById(R.id.homeButton));
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MyPlants.this, MainActivity.class));
            }
        });

        // In test mode, this button sets the first plant in the system to have a moisture level
        // that requires it to be watered.
        Button testMoistureLowButton = (Button)(findViewById(R.id.testMoistureLowBtn));
        testMoistureLowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MyPlants.this, testMoistureLow.class));
            }
        });

        // In test mode, this button sets the first plant in the system to have a moisture level
        // that does NOT require it to be watered
        Button testMoistureHighButton = (Button)(findViewById(R.id.testMoistureHighBtn));
        testMoistureHighButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MyPlants.this, testMoistureHigh.class));
            }
        });

        // Initialize navigation buttons
        final Button nextBtn = (Button)(findViewById(R.id.nextButton));
        final Button prevBtn = (Button)(findViewById(R.id.prevButton));
        if(LocalStorage.plantList.size() < 2)
            nextBtn.setVisibility(View.INVISIBLE);

        /*
        When the 'next' navigation button is selected, the plant count increases, the navigation
        button to go to the previous plant becomes visible, and the current plant is updated.
         */
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                plantCnt++;
                updateCurrentPlant(plantCnt);
                prevBtn.setVisibility(View.VISIBLE);
                // Check for maximum plants constraint
                if(plantCnt == LocalStorage.plantList.size()-1) {
                    nextBtn.setVisibility(View.INVISIBLE);
                    if(LocalStorage.plantList.size() < 3)
                        addBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        /*
        When the 'previous' navigation button is selected, the plant count decreases, the navigation
        button to go to the next plant becomes visible, and the current plant is updated.
         */
        prevBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                plantCnt--;
                updateCurrentPlant(plantCnt);
                nextBtn.setVisibility(View.VISIBLE);
                addBtn.setVisibility(View.INVISIBLE);
                // If at the first plant in the list, make the previous button invisible
                if(plantCnt == 0)
                    prevBtn.setVisibility(View.INVISIBLE);
            }
        });

        // Set button visibility
        prevBtn.setVisibility(View.INVISIBLE);
        testMoistureHighButton.setVisibility(View.INVISIBLE);
        testMoistureLowButton.setVisibility(View.INVISIBLE);

        // Initialize text fields
        mockVal = (EditText) findViewById(R.id.editMockHumidity);
        showName = (TextView) findViewById(R.id.textName);
        showMoisture = (TextView) findViewById(R.id.textMoisture);
        moistureLabel = (TextView) findViewById(R.id.moistureLevelUI);
        noPlants = (TextView) findViewById(R.id.noPlantsText);
        // Set visibility for text fields
        showName.setVisibility(View.INVISIBLE);
        showMoisture.setVisibility(View.INVISIBLE);
        moistureLabel.setVisibility(View.INVISIBLE);
        mockVal.setVisibility(View.INVISIBLE);

        // Set test buttons to visible if test mode is enabled
        if(LocalStorage.testMode) {
            testMoistureHighButton.setVisibility(View.VISIBLE);
            testMoistureLowButton.setVisibility(View.VISIBLE);
        }


        // Load plants from ArrayList (in LocalStorage)
        if(!LocalStorage.plantList.isEmpty()) {
            updateCurrentPlant(0);
        }
        else {
            addBtn.setVisibility(View.VISIBLE);
        }
    }

    // Updates the current plant shown on screen according to the plant count variable
    public void updateCurrentPlant(int i) {

        currentPlant = (Plant) LocalStorage.plantList.get(i);
        showName.setText(currentPlant.getName());
        showMoisture.setText(String.valueOf (currentPlant.getMoisture()));
        showName.setVisibility(View.VISIBLE);
        showMoisture.setVisibility(View.VISIBLE);
        moistureLabel.setVisibility(View.VISIBLE);
        noPlants.setVisibility(View.INVISIBLE);

    }


}
