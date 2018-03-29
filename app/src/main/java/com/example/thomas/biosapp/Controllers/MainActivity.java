package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.example.thomas.biosapp.Api.FilmTask;
import com.example.thomas.biosapp.Api.OnFilmAvailable;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.TestFragment;
import com.example.thomas.biosapp.TestFragmentThree;
import com.example.thomas.biosapp.TestFragmentTwo;
import com.example.thomas.biosapp.Util.FilmGridAdapter;
import com.example.thomas.biosapp.Util.PagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> films;
    private FilmGridAdapter filmGridAdapter;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tijdelijk veranderd naar R.layout_activity_films_tab, default is activity_main
        setContentView(R.layout.activity_main);

        //Bypass
        Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(intent);

        //Gridview instellen
        GridView gridview = (GridView) findViewById(R.id.filmGridView);
        gridview.setAdapter(new FilmGridAdapter(this));
        gridview.setOnItemClickListener(this);
    }
//        films = new ArrayList<>();
//
//        //Gridview instellen
//        GridView gridview = (GridView) findViewById(R.id.filmGridView);
//        //@TODO fix
//        filmGridAdapter = new FilmGridAdapter(getApplicationContext(), getLayoutInflater(), films);
//        gridview.setAdapter(filmGridAdapter);
//        gridview.setOnItemClickListener(this);
//        this.getFilmItems();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

//    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//        //Juiste film verkrijgen
//        //Film film =
//        Film film = (Film) films.get(position);
//        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
//        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
//        intent.putExtra("FILM_OBJECT", film);
//        startActivity(intent);
//    }

//    public void getFilmItems() {
//        films.clear();
//        FilmTask task = new FilmTask(this);
//        String[] urls = new String[]{FilmTask.filmQueries.popularUrl};
//        task.execute(urls);
//    }

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


//    @Override
//    public void onFilmAvailable(Film film) {
//        films.add(film);
//        filmGridAdapter.notifyDataSetChanged();
//    }

    private void setupViewPager(ViewPager viewPager){
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        Fragment fragment = new TestFragment();
        adapter.addFragment(fragment, "ONE");
        adapter.addFragment(new TestFragmentTwo(), "TWO");
        adapter.addFragment(new TestFragmentThree(), "THREE");
        viewPager.setAdapter(adapter);
    }
}
