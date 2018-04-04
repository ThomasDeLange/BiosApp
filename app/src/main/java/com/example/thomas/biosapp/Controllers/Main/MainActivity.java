package com.example.thomas.biosapp.Controllers.Main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.Controllers.Contact.ContactFragment;
import com.example.thomas.biosapp.Controllers.Tickets.TicketOverviewFragment;
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
    private MainFragment mainFragment;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tijdelijk veranderd naar R.layout_activity_films_tab, default is activity_main
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getColor(R.color.colorText));
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getColor(R.color.colorText), getColor(R.color.colorText));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Verander toolbar menu
        getMenuInflater().inflate(R.menu.menu_search, menu);

        //Verkrijg de zoekknop
        SearchView searchView = (android.support.v7.widget.SearchView) menu.findItem(R.id.search_button).getActionView();
        System.out.println(searchView.getSolidColor());

        //Voeg zoekactie toe aan zoekknop die in de mainfragment staat
        searchView.setOnQueryTextListener(mainFragment);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupViewPager(ViewPager viewPager){
        adapter = new PagerAdapter(getSupportFragmentManager());

        ContactFragment contactFragment = new ContactFragment();
        TicketOverviewFragment ticketOverviewFragment = new TicketOverviewFragment();

        adapter.addFragment(mainFragment, "Overzicht");
        adapter.addFragment(contactFragment, "Contact");
        adapter.addFragment(ticketOverviewFragment, "Tickets");

        viewPager.setAdapter(adapter);
    }
}
