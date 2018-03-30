package com.example.thomas.biosapp.Controllers.Main;

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

<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/MainActivity.java
        //Bypass
        Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(intent);

=======
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/MainActivity.java
        //Gridview instellen
        films = new ArrayList<Film>();
        GridView gridview = (GridView) findViewById(R.id.filmGridView);
<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/MainActivity.java
        gridview.setAdapter(new FilmGridAdapter(this));
=======
  
        filmGridAdapter = new FilmGridAdapter(getApplicationContext(), getLayoutInflater(), films);
        gridview.setAdapter(filmGridAdapter);
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/MainActivity.java
        gridview.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        //Juiste film verkrijgen
<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/MainActivity.java
        //Film film =
=======
        Film film = films.get(position);
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/MainActivity.java

        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
        //intent.putExtra("PHOTO_OBJECT", film);
        startActivity(intent);
    }

    @Override
<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/MainActivity.java
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
=======
    public void onFilmAvailable(Film film) {
        films.add(film);
        filmGridAdapter.notifyDataSetChanged();
    }
    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        //Verander toolbar menu
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//
//        /*
//        //Verkrijg de zoekknop
//        SearchView searchView = (android.support.v7.widget.SearchView)menu.findItem(R.id.filterButton);
//
//        //Voeg zoekactie toe aan zoekknop
//        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(MainActivity.this, "Zoeken op '" + query + "'", Toast.LENGTH_SHORT);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });*/
//        return super.onCreateOptionsMenu(menu);
//    }
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/MainActivity.java
}
