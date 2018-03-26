package com.example.thomas.biosapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.thomas.biosapp.Api.FilmTask;
import com.example.thomas.biosapp.Api.OnFilmAvailable;
import com.example.thomas.biosapp.Controllers.DetailedActivity;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Util.FilmGridAdapter;
import com.example.thomas.biosapp.R;

import java.util.ArrayList;

/**
 * Created by steph on 26-3-2018.
 */

public class TestFragment extends Fragment implements OnFilmAvailable, AdapterView.OnItemClickListener{

    private ArrayList<Film> films;
    private GridView gridview;
    private FilmGridAdapter filmGridAdapter;
    private boolean loaded;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Fragment is nog niet geladen
        loaded = false;
        films = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Grid initializeren
        gridview = (GridView) getView().findViewById(R.id.filmGridView);
        gridview.setOnItemClickListener(this);

        //Adapter initializieren
        filmGridAdapter = new FilmGridAdapter(getContext(), getLayoutInflater(), films);
        gridview.setAdapter(filmGridAdapter);

        //Films verkrijgen indien dit nog niet is gebeurt
        getFilmItems();
    }

    public void getFilmItems() {

        //Film array legen en films uit de filmtaak halen
        films.clear();
        FilmTask task = new FilmTask(this);
        String[] urls = new String[]{FilmTask.filmQueries.popularUrl};
        task.execute(urls);
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        //Juiste film verkrijgen
        Film film = (Film) films.get(position);

        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getActivity().getApplicationContext(), DetailedActivity.class);
        intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films_tab, container, false);
    }

    @Override
    public void onFilmAvailable(Film film) {

        //Film toevoegen
        films.add(film);
    }

    @Override
    public void onFilmsLoaded() {

        //1X grid updaten, beter voor performance
        filmGridAdapter.notifyDataSetChanged();

        //Fragment geladen, fragment één enkele keer refreshen
        if (!loaded) {
            loaded = true;
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}
