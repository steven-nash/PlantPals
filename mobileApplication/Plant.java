package com.example.steve.plantpals;

/**
 * Created by steve on 11/6/2017.
 * Steven Nash
 * Plant:
 *      Object type 'Plant' that includes a value for a name and an ideal moisture.
 */

public class Plant {
    String name; // Name of the plant
    int moisture; // Prefered moisture level for the plant

    // Initialize new manually added plant
    public Plant() {
        name = "New Plant";
        moisture = 0;
    }

    // Initialize new plant - parameters from database
    public Plant(String n, int m) {
        name = n;
        moisture = m;
    }

    // Get the name of the plant
    public String getName() {
        return name;
    }

    //Get the set moisture preference for the plant
    public int getMoisture() {
        return moisture;
    }

    // Set a new name for the plant
    public void setName(String n) {
        name = n;
    }

}
