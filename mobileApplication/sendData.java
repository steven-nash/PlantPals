package com.example.steve.plantpals;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonWriter;

import org.apache.http.HttpClientConnection;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by steve on 11/20/2017
 * Steven Nash 
 * sendData:
 *      Send the plant at index cnt from the user's plant list to the HTML server
 */

public class sendData extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... cnt) {
        return sendPlantList(cnt[0]);
    }

    public Boolean sendPlantList(String cnt) {
        try {
            // Parse the number in the string parameter to an integer
            int cntVal = Integer.parseInt(cnt);

            // Set up the HTTP connection between the android client and the server on the same network
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://172.20.10.6/steve4.php");
            // Create the list of name-value pairs to be sent through post to the server
            List<NameValuePair> plantValuePairs = new ArrayList<NameValuePair>(4);

            // Retrieve the plant to be sent from the user's plant list
            Plant currPlant = (Plant) LocalStorage.plantList.get(cntVal);
            // Add the current plant's data into the list separately with a key and value
            plantValuePairs.add(new BasicNameValuePair("plantName", currPlant.getName()));
            plantValuePairs.add(new BasicNameValuePair("idealMoist", Integer.toString(currPlant.getMoisture())));
            plantValuePairs.add(new BasicNameValuePair("position", Integer.toString(cntVal+1)));

            // Set the entity to be sent through post as the list and execute
            httpPost.setEntity(new UrlEncodedFormEntity(plantValuePairs));
            httpClient.execute(httpPost);


            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
