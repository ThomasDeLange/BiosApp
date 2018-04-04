package com.example.thomas.biosapp.Controllers.Seats;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.FilmGridAdapter;
import com.squareup.picasso.Picasso;

import java.net.URL;

/**
 * Created by steph on 3-4-2018.
 */

public class TicketSelectionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewTicketSelection;
    private Film film;
    private Button confirmButton;
    private ImageView ticketPoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_selection);

        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");
        textViewTicketSelection = (TextView) findViewById(R.id.filmTicketTitle);
        textViewTicketSelection.setText(film.getName());

        ticketPoster = (ImageView) findViewById(R.id.filmImage);

        Picasso.get().load(film.getPosterUrl()).into(ticketPoster);



        confirmButton = (Button) findViewById(R.id.buttonConfirmTickets);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SeatsActivity.class);
        intent.putExtra("TICKET_OBJECT", film);
        startActivity(intent);
    }
}
