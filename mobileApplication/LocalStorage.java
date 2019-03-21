package com.example.steve.plantpals;

import java.util.ArrayList;

/**
 * Created by steve on 11/6/2017.
 * Steven Nash 
 * LocalStorage:
 *      This class was created as a temporary save location for values used globally in the app.
 *      This data is erased upon the closing of the application.
 */

public class LocalStorage {
    // User's plant list
    public static ArrayList plantList = new ArrayList<Plant>();
    // Boolean for whether test mode is enabled or not
    public static boolean testMode = false;
}

