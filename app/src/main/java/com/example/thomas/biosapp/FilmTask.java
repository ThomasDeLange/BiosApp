package com.example.thomas.biosapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by steph on 21-3-2018.
 */

public class FilmTask extends AsyncTask<String, Void, String> {

    private OnFilmAvailable listener = null;
    private static final String TAG = FilmTask.class.getSimpleName();

    public FilmTask(OnFilmAvailable listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        InputStream inputStream = null;
        int responseCode = -1;
        String filmUrl = strings[0];
        String response = "";

        try{
            URL url = new URL(filmUrl);
            URLConnection urlConnection = url.openConnection();
            if(!(urlConnection instanceof HttpURLConnection)){
                return null;
            }
            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            responseCode = httpConnection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                inputStream = httpConnection.getInputStream();
                response = getStringFromInputStream(inputStream);
            }else{
                Log.e(TAG, "Error, invalid response");
            }
        }catch(MalformedURLException e){
            Log.e(TAG, "doInBackground MalformedURLEXception " + e.getLocalizedMessage());
            return null;
        }catch(IOException e){
            Log.e(TAG, "doInBackground IOException " + e.getLocalizedMessage());
            return null;
        }
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        Log.i(TAG, "onPostExecute " + response);
        if(response == null || response == ""){
            Log.e(TAG, "onPostExecute empty response");
            return;
        }

        JSONObject jsonObject;
        try{
            jsonObject = new JSONObject(response);
        }catch(JSONException e){
            Log.e(TAG, "onPostExecute JSONException " + e.getLocalizedMessage());
        }
    }

    private static String getStringFromInputStream(InputStream inputStream){
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(bufferedReader != null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
