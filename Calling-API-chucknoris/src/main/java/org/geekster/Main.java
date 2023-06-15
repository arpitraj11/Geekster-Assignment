package org.geekster;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        String urlString = "https://api.chucknorris.io/jokes/random";


        URL url = new URL(urlString);


        //connection

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();


        //extract information from the connection object:

        if(responseCode == 200){
            BufferedReader byteCodes = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readline = null;

            while((readline = byteCodes.readLine()) != null){
                apiData.append(readline);
            }

            byteCodes.close();

//            To convert String to JSON
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            System.out.println(jsonAPIResponse);
            System.out.println(jsonAPIResponse.get("icon_url"));
            System.out.println(jsonAPIResponse.get("updated_at"));
            System.out.println(jsonAPIResponse.get("created_at"));
            System.out.println(jsonAPIResponse.get("id"));
            System.out.println(jsonAPIResponse.get("value"));
            System.out.println(jsonAPIResponse.get("url"));
            System.out.println(jsonAPIResponse.get("categories"));
        }
        else
            System.out.println("API call could not be made!!!");

    }
}