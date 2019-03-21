package com.example.steve.plantpals;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;


/**
 * Created by steve on 11/20/2017.
 * Steven Nash 
 * receiveData:
 *      Receive the user's plant list from the network
 */

public class receiveData extends AsyncTask<String, Void, ArrayList<Plant>> {

    // Initialize the ArrayList of plants to be received
    ArrayList<Plant> receivedPlants = new ArrayList<Plant>();

    // Set the task to do in the background to avoid server hold-ups from affecting the GUI
    @Override
    protected ArrayList<Plant> doInBackground(String... urlParam) {
        return LocalStorage.plantList = receivePlantList(urlParam[0]);
    }


    //receive plant list
    public ArrayList<Plant> receivePlantList(String ip) {
        // HTTP request
        try {
            String urlStr = "http://" + java.net.URLEncoder.encode(ip, "UTF-8") + "/steve3.php";
            URL url = new URL(urlStr);
            URLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.getContent();

            // Start data stream/readers
            BufferedReader reader = null;
            InputStream stream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            JsonReader jReader = new JsonReader(reader);

            // Get items from JSON object and place in a plant list
            jReader.beginArray();
            while (jReader.hasNext()) {
                try {
                    String plantName = jReader.nextString();
                    int plantMoisture = jReader.nextInt();
                    Plant currentPlant = new Plant(plantName, plantMoisture);
                    receivedPlants.add(currentPlant);
                } catch (IllegalStateException ise){
                    return receivedPlants = new ArrayList<Plant>();
                }
            }
            // Close all readers
            jReader.endArray();
            reader.close();
            stream.close();
            jReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the plant list retreived from server
        return receivedPlants;
    }
}
