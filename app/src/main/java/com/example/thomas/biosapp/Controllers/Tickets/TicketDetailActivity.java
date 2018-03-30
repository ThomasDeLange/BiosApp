package com.example.thomas.biosapp.Controllers.Tickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.squareup.picasso.Picasso;

public class TicketDetailActivity extends AppCompatActivity {

    private Ticket ticket;
    private TextView filmTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);

        Bundle extras = getIntent().getExtras();

        ticket = (Ticket) extras.getSerializable("TICKET_OBJECT");

        filmTitle = findViewById(R.id.filmTitleView);
        filmTitle.setText(ticket.getFilmTitle());

        //Picasso.get().load(ticket.getPosterURl()).into(posterView);
    }
}
