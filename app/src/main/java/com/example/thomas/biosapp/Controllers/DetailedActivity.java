package com.example.thomas.biosapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.R;

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
        //Film film = (Film)getIntent().getSerializableExtra("FILM_OBJECT");
        //RequestCreator requestCreator = Picasso.with(getApplicationContext()).load(photo.getImageSource());

        //Data aanpassen
        //filmDetailedTitle.setText(film.set)
        //requestCreator.into(filmDetailedImage);
        //filmDetailedDescription.setText(film.set)

        //Actie achter reserveer knop
        filmDetailedOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Reserveren
        Toast.makeText(DetailedActivity.this, "Reserveren", Toast.LENGTH_SHORT).show();
    }
}
