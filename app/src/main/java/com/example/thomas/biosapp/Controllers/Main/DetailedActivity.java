package com.example.thomas.biosapp.Controllers.Main;

<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/DetailedActivity.java
=======
import android.content.Intent;
import android.os.Bundle;
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/DetailedActivity.java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/DetailedActivity.java
=======
import com.example.thomas.biosapp.Controllers.Seats.SeatsActivity;
import com.example.thomas.biosapp.Domain.Film;
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/DetailedActivity.java
import com.example.thomas.biosapp.R;

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
        TextView filmDetailedDescription = findViewById(R.id.filmDetailedDescription);

        //Meegestuurde gegevens verkrijgen
<<<<<<< HEAD:app/src/main/java/com/example/thomas/biosapp/Controllers/DetailedActivity.java
        //Film film = (Film)getIntent().getSerializableExtra("FILM_OBJECT");
        //RequestCreator requestCreator = Picasso.with(getApplicationContext()).load(photo.getImageSource());
=======
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");
        RequestCreator requestCreator = Picasso.get().load(film.getPosterUrl());
>>>>>>> TicketBesteling:app/src/main/java/com/example/thomas/biosapp/Controllers/Main/DetailedActivity.java

        //Data aanpassen
        //filmDetailedTitle.setText(film.set)
        //requestCreator.into(filmDetailedImage);
        //filmDetailedDescription.setText(film.set)

        //Actie achter reserveer knop
        filmDetailedOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        //Intent intent = new Intent(getApplicationContext(), TicketSeatInfoActivity.class);
        //intent.putExtra("FILM_OBJECT", film);
        //Verzoeken om naar een nieuw venster te gaan met het juiste film object
        Intent intent = new Intent(getApplicationContext(), SeatsActivity.class);
        intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }
}

