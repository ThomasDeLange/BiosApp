package com.example.thomas.biosapp.Controllers.Main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thomas.biosapp.Controllers.Tickets.TicketViewActivity;
import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.TicketsAdapter;

import java.util.ArrayList;

/**
 * Created by steph on 26-3-2018.
 */

public class TicketOverviewFragment extends Fragment {

    private ListView listView;
    private ArrayList<Ticket> ticketArrayList;
    private TicketsAdapter ticketsAdapter;
    private TicketDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View creeër
        View view = inflater.inflate(R.layout.activity_tickets, container, false);
        this.listView = (ListView) view.findViewById(R.id.ticketListView);

        database = new TicketDatabase(getContext());
        ticketArrayList = database.getAllTickets();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("SelectedItem: ", i + "");

                Ticket ticket = (Ticket) ticketArrayList.get(i);

                Intent intent = new Intent(view.getContext(), TicketViewActivity.class);
                intent.putExtra("TICKET_OBJECT", ticket);
                startActivity(intent);
            }
        });

        //Zet de data in de listview door via een adapter de data aan de listview te koppelen
        this.ticketsAdapter = new TicketsAdapter(getContext(), ticketArrayList);
        this.listView.setAdapter(ticketsAdapter);

        // Inflate the layout for this fragment
        return view;
    }

}
