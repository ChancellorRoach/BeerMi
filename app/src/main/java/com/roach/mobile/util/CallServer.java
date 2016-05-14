package com.roach.mobile.util;

/**
 * Created by juanroca on 5/14/2016.
 */
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Logger;

public class CallServer extends AsyncTask<String, String, String> {

    private static final Logger log = Logger.getLogger(String.valueOf(CallServer.class));

    protected String doInBackground(String...params){
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        StringBuffer response = null;
        String call = params[0];
        String accessToken = params[1];

        try {
            URL url = new URL(call);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Authorization", "Token " + accessToken);


            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();

            log.info("\nSending 'GET' request to URL : " + url);
            log.info("Response Code : " + responseCode);

            JSONObject json = new JSONObject();
            json.put("responseCode", responseCode);

            in  = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            log.info("Response: " + response.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            StreamUtil.safelyCloseStream(urlConnection);
            StreamUtil.safelyCloseStream(inputStream);
            StreamUtil.safelyCloseStream(in);
        }


        return response.toString();
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(InputStream inputStream) {
        //showDialog("Downloaded " + result + " bytes");

    }


}