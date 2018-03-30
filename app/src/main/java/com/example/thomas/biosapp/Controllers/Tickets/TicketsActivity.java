package com.example.thomas.biosapp.Controllers.Tickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Buyer;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Seat;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.TicketsAdapter;

import java.util.ArrayList;

public class TicketsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Ticket> ticketArrayList;
    private TicketsAdapter ticketsAdapter;
    private TicketDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        this.listView = (ListView) findViewById(R.id.ticketListView);

        database = new TicketDatabase(this);
        ticketArrayList = database.getTickets();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("SelectedItem: ", i + "");

                Ticket ticket = (Ticket) ticketArrayList.get(i);

                Intent intent = new Intent(getApplicationContext(), TicketDetailActivity.class);
                intent.putExtra("TICKET_OBJECT", ticket);
                startActivity(intent);
            }
        });

        //Zet de data in de listview door via een adapter de data aan de listview te koppelen
        this.ticketsAdapter = new TicketsAdapter(this, ticketArrayList);
        this.listView.setAdapter(ticketsAdapter);

    }

    public static class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener {

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
}
