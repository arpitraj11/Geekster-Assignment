package org.geekster;



import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String urlString = "https://api.zippopotam.us/us/33162";
        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;

        // Creating a URL
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("problem in URL");
        }

        // Connection
        try{
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            System.out.println("connection problem");
        }

        StringBuilder apiData = new StringBuilder();
        if(responseCode == 200){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String readLine = null;

                while((readLine = in.readLine()) != null){
                    apiData.append(readLine);
                }
                in.close();
            } catch (IOException e) {
                System.out.println("404 error");
            }

            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());


            System.out.println(jsonAPIResponse.get("post code"));
            System.out.println(jsonAPIResponse.get("country"));
            System.out.println(jsonAPIResponse.get("country abbreviation"));
            System.out.println(jsonAPIResponse.get("places"));

        }
        else
            System.out.println("API call could not be made");

    }
}