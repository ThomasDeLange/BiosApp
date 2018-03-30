package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.thomas.biosapp.Api.FilmTask;
import com.example.thomas.biosapp.Api.OnFilmAvailable;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.FilmGridAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, OnFilmAvailable {

    private ArrayList<Film> films;
    private FilmGridAdapter filmGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gridview instellen
        films = new ArrayList<Film>();
        GridView gridview = (GridView) findViewById(R.id.filmGridView);
  
        filmGridAdapter = new FilmGridAdapter(getApplicationContext(), getLayoutInflater(), films);
        gridview.setAdapter(filmGridAdapter);
        gridview.setOnItemClickListener(this);
        this.getFilmItems();
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        //Juiste film verkrijgen
        Film film = films.get(position);
        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
        intent.putExtra("FILM_OBJECT", film);
        //intent.putExtra("DATABASE_OBJECCT", this.ticketDatabase);
        startActivity(intent);
    }

    public void getFilmItems() {
        films.clear();
        FilmTask task = new FilmTask(this);
        String[] urls = new String[]{FilmTask.filmQueries.popularUrl};
        task.execute(urls);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Verander toolbar menu
        getMenuInflater().inflate(R.menu.menu_search, menu);

        /*
        //Verkrijg de zoekknop
        SearchView searchView = (android.support.v7.widget.SearchView)menu.findItem(R.id.filterButton);

        //Voeg zoekactie toe aan zoekknop
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Zoeken op '" + query + "'", Toast.LENGTH_SHORT);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onFilmAvailable(Film film) {
        films.add(film);
        filmGridAdapter.notifyDataSetChanged();
    }
}
