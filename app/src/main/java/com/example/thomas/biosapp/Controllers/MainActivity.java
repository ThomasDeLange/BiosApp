package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.support.v7.widget.SearchView;

import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.FilmGridAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bypass
        Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(intent);

        //Gridview instellen
        GridView gridview = (GridView) findViewById(R.id.filmGridView);
        gridview.setAdapter(new FilmGridAdapter(this));
        gridview.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        //Juiste film verkrijgen
        //Film film =

        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
        //intent.putExtra("PHOTO_OBJECT", film);
        startActivity(intent);
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
}
