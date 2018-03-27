package com.example.thomas.biosapp.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thomas.biosapp.Database.TicketDatabase.TicketDatabase;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener {

    Button buyTicketButton;
    TicketDatabase ticketDatabase;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        buyTicketButton = (Button) findViewById(R.id.buyTicketButton);
        buyTicketButton.setOnClickListener(this);

        ticketDatabase = new TicketDatabase(getApplicationContext());

        //Meegestuurde gegevens verkrijgen
        //ticketDatabase = (TicketDatabase) getIntent().getSerializableExtra("DATABASE_OBJECT");
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");

    }

    @Override
    public void onClick(View v) {
        //Reserveren
        Toast.makeText(BuyTicketActivity.this, "Reserveren", Toast.LENGTH_SHORT).show();
        ticketDatabase.buyTicket(film);
    }
}
