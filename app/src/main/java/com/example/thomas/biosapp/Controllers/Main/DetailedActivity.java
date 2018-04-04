package com.example.thomas.biosapp.Controllers.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Controllers.Contact.FeedbackActivity;
import com.example.thomas.biosapp.Controllers.Seats.SeatsActivity;
import com.example.thomas.biosapp.Controllers.Seats.TicketSelectionActivity;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class DetailedActivity extends AppCompatActivity implements View.OnClickListener {

    Film film;
    //TicketDatabase ticketDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //Views verkrijgen
        TextView filmDetailedTitle = findViewById(R.id.filmDetailedTitle);
        ImageView filmDetailedImage = findViewById(R.id.filmDetailedImage);
        Button filmDetailedOrder = findViewById(R.id.filmDetailedOrder);
        Button buttonGiveMovieFeedback = findViewById(R.id.buttonGiveMovieFeedback);
        TextView filmDetailedDescription = findViewById(R.id.filmDetailedDescription);

        //Meegestuurde gegevens verkrijgen
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");
        RequestCreator requestCreator = Picasso.get().load(film.getPosterUrl());

        //Data aanpassen
        filmDetailedTitle.setText(film.getName());
        requestCreator.into(filmDetailedImage);
        filmDetailedDescription.setText(film.getDescription());

        //Actie achter reserveer knop
        filmDetailedOrder.setOnClickListener(this);
        buttonGiveMovieFeedback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        //Intent intent = new Intent(getApplicationContext(), TicketSeatInfoActivity.class);
        //intent.putExtra("FILM_OBJECT", film);
        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = null;
        switch (v.getId()) {
            case R.id.filmDetailedOrder:
                intent = new Intent(getApplicationContext(), SeatsActivity.class);
                break;
            case R.id.buttonGiveMovieFeedback:
                intent = new Intent(getApplicationContext(), FeedbackActivity.class);
                break;
        }

        intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }
}

