package com.example.thomas.biosapp.Controllers.Tickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.TicketsAdapter;

import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Ticket> ticketArrayList;
    private TicketsAdapter ticketsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        this.listView = (ListView) findViewById(R.id.ticketListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("SelectedItem: ", i + "");

                Ticket ticket = (Ticket) ticketArrayList.get(i);

                //Intent intent = new Intent(getApplicationContext(), DetailTicketAcitity.class);
                //intent.putExtra("TICKET_OBJECT", ticket);
                //startActivity(intent);
            }
        });

        //Zet de data in de listview door via een adapter de data aan de listview te koppelen
        this.ticketsAdapter = new TicketsAdapter(this, ticketArrayList);
        this.listView.setAdapter(ticketsAdapter);

    }
}
