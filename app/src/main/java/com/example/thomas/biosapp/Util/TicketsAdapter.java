package com.example.thomas.biosapp.Util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TicketsAdapter extends ArrayAdapter<Ticket> {


    public TicketsAdapter(@NonNull Context context, ArrayList<Ticket> ticketArrayList) {
        super(context, 0, ticketArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Photo ophalen
        Ticket ticket = getItem(position);

        // View aanmaken of herbruiken
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.ticket_listview_item,
                    parent,
                    false
            );
        } else {
            convertView = convertView;
        }

        // Koppelen datasource aan UI
        ImageView filmPoster = (ImageView) convertView.findViewById(R.id.filmPosterView);
        TextView filmTitle = (TextView) convertView.findViewById(R.id.filmTitleView);
        TextView filmRuntime = (TextView) convertView.findViewById(R.id.filmRuntimeView);

        Picasso.get().load(ticket.getPosterURL()).into(filmPoster);
        filmTitle.setText(ticket.getFilmTitle());
        filmRuntime.setText(ticket.getRunTime());

        return convertView;

    }
}
