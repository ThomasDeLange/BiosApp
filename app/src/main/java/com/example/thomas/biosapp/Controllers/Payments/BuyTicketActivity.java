package com.example.thomas.biosapp.Controllers.Payments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Buyer;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Seat;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener {

    Button buyTicketButton;
    Button testBuyTicketButton;
    TicketDatabase ticketDatabase;
    Film film;
    Buyer buyer;
    Ticket ticket;
    Seat seat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        buyTicketButton = findViewById(R.id.buyTicketButton);
        buyTicketButton.setOnClickListener(this);

        testBuyTicketButton = findViewById(R.id.testBuyTicket);
        testBuyTicketButton.setOnClickListener(this);


        ticketDatabase = new TicketDatabase(getApplicationContext());

        //Meegestuurde gegevens verkrijgen
        //ticketDatabase = (TicketDatabase) getIntent().getSerializableExtra("DATABASE_OBJECT");
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buyTicketButton:

                //ticketDatabase.buyTicket(film, buyer, ticket, seat);
                break;

            case R.id.testBuyTicket:

                ticketDatabase.printTickets();
                break;

            default:
                break;
        }
    }
}
