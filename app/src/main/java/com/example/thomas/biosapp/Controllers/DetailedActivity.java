package com.example.thomas.biosapp.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class DetailedActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //Views verkrijgen
        TextView filmDetailedTitle = findViewById(R.id.filmDetailedTitle);
        ImageView filmDetailedImage = findViewById(R.id.filmDetailedImage);
        Button filmDetailedOrder = findViewById(R.id.filmDetailedOrder);
        TextView filmDetailedDescription = findViewById(R.id.filmDetailedDescription);

        //Meegestuurde gegevens verkrijgen
        Film film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");
        RequestCreator requestCreator = Picasso.get().load(film.getPosterUrl());

        //Data aanpassen
        filmDetailedTitle.setText(film.getName());
        requestCreator.into(filmDetailedImage);
        filmDetailedDescription.setText(film.getDescription());

        //Actie achter reserveer knop
        filmDetailedOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Reserveren
        Toast.makeText(DetailedActivity.this, "Reserveren", Toast.LENGTH_SHORT).show();
    }
}
