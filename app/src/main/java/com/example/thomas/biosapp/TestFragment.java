package com.example.thomas.biosapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

    private ArrayList<Film> films = new ArrayList<>();
    private GridView gridview;
    private FilmGridAdapter filmGridAdapter;

    public TestFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        //Gridview instellen
        gridview = (GridView) getActivity().findViewById(R.id.filmGridView);
        //@TODO fix
        filmGridAdapter = new FilmGridAdapter(getActivity().getApplicationContext(), getLayoutInflater(), films);
        gridview.setAdapter(filmGridAdapter);
        gridview.setOnItemClickListener(this);
        this.getFilmItems();


    }

    public void getFilmItems() {
        films.clear();
        FilmTask task = new FilmTask(this);
        String[] urls = new String[]{FilmTask.filmQueries.popularUrl};
        task.execute(urls);
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        //Juiste film verkrijgen
        //Film film =
        Film film = (Film) films.get(position);
        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getActivity().getApplicationContext(), DetailedActivity.class);
        intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films_tab, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onFilmAvailable(Film film) {
        films.add(film);
        filmGridAdapter.notifyDataSetChanged();
    }


}
