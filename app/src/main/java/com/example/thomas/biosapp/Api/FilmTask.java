package com.example.thomas.biosapp.Api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.thomas.biosapp.Domain.Film;

import org.json.JSONArray;
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

    private static final String TAG = FilmTask.class.getSimpleName();
    private OnFilmAvailable listener = null;

    public FilmTask(OnFilmAvailable listener) {
        this.listener = listener;
    }

    private static String getStringFromInputStream(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    protected String doInBackground(String... strings) {
        InputStream inputStream = null;
        int responseCode = -1;
        String filmUrl = strings[0];
        String response = "";

        try {
            URL url = new URL(filmUrl);
            URLConnection urlConnection = url.openConnection();
            if (!(urlConnection instanceof HttpURLConnection)) {
                return null;
            }
            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpConnection.getInputStream();
                response = getStringFromInputStream(inputStream);
            } else {
                Log.e(TAG, "Error, invalid response");
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "doInBackground MalformedURLEXception " + e.getLocalizedMessage());
            return null;
        } catch (IOException e) {
            Log.e(TAG, "doInBackground IOException " + e.getLocalizedMessage());
            return null;
        }
        return response;

    }

    @Override
    protected void onPostExecute(String response) {
        Log.i(TAG, "onPostExecute " + response);
        if (response == null || response == "") {
            Log.e(TAG, "onPostExecute empty response");
            return;
        }

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);

            JSONArray results = jsonObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject film = results.getJSONObject(i);

                String movieTitle = film.getString("original_title");
                String posterUrl = film.getString("poster_path");
                String description = film.getString("overview");
                String id = film.getString("id");
                Log.i(TAG, "Got film: " + movieTitle);

                Film f = new Film(movieTitle, posterUrl, description, id);
                f.setName(movieTitle);
                f.setPosterUrl(filmQueries.secureImageUrl + posterUrl);
                f.setDescription(description);
                f.setId(id);
                listener.onFilmAvailable(f);
            }

        } catch (JSONException e) {
            Log.e(TAG, "onPostExecute JSONException " + e.getLocalizedMessage());
        }
    }

    public static class filmQueries {
        //append image_path to secureImageUrl, always use "poster_path"
        public static final String secureImageUrl = "https://image.tmdb.org/t/p/w300/";
        //retrieve a list split in pages in a JSONArray "results", default is page=1
        public static final String popularUrl = "https://api.themoviedb.org/3/movie/popular?api_key=f2a602049196e977fd3fc61a45ffe4ac&language=nl&page=1";

    }
}
