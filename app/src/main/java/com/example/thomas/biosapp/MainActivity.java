package com.example.thomas.biosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnFilmAvailable, View.OnClickListener{

    private ArrayList<Film> films;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        films = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        Log.i("BUTTON", "onClick aangeroepen");
        String[] urls = new String[] {FilmTask.filmQueries.popularUrl};
        FilmTask getFilm = new FilmTask(this);
        getFilm.execute(urls);
    }

    @Override
    public void onFilmAvailable(Film film) {
        films.add(film);
    }
}
