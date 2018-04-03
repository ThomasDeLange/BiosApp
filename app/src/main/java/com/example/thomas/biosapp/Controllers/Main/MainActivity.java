package com.example.thomas.biosapp.Controllers.Main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.support.v7.widget.Toolbar;

import com.example.thomas.biosapp.Controllers.ContactFragment;
import com.example.thomas.biosapp.Controllers.MainFragment;
import com.example.thomas.biosapp.Controllers.TicketOverviewFragment;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
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
                Toast.makeText(MainActivityOld.this, "Zoeken op '" + query + "'", Toast.LENGTH_SHORT);
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
        Fragment fragment = new MainFragment();
        adapter.addFragment(fragment, "Overzicht");
        adapter.addFragment(new ContactFragment(), "Contact");
        adapter.addFragment(new TicketOverviewFragment(), "Tickets");
        viewPager.setAdapter(adapter);
    }
}
