package com.example.thomas.biosapp.Controllers.Seats;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thomas.biosapp.Controllers.Payments.PaymentActivity;
import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Seat;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap redChair;
    private Bitmap blueChair;
    private Bitmap greenChair;

    private HashMap<ImageView, Integer> seats;
    private TextView textViewChairSelected;
    private final String CHAIR_ID_NAME = "selectableChair";
    private ArrayList<Integer> selectedChairIDs;
    private Spinner spinnerChairAmount;
    private Film film;
    private TicketDatabase database;
    private int lastSeat;
    private ArrayList<Integer> orderedSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        //Database
        database = new TicketDatabase(this);

        //Chairlijst aanmaken
        selectedChairIDs = new ArrayList<Integer>();
        redChair = BitmapFactory.decodeResource(getResources(), R.drawable.chair_red);
        blueChair = BitmapFactory.decodeResource(getResources(), R.drawable.chair_blue);
        greenChair = BitmapFactory.decodeResource(getResources(), R.drawable.chair_green);

        //Laad select text
        textViewChairSelected = findViewById(R.id.textViewChairSelected);

        //Laad selecteerknop
        Button buttonSelectChair = findViewById(R.id.buttonSelectChair);
        buttonSelectChair.setOnClickListener(this);

        //Verkrijg intent
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");

        //Verkrijg stoelen
        getSeats();

        //Spinner
        createSpinner();
    }

    private void createSpinner() {

        //Spinner
        spinnerChairAmount = findViewById(R.id.spinnerChairAmount);
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        int maxAmount = seats.size() > 9 ? 9 : seats.size();
        for (int a = 1; a <= maxAmount; a++)
            integerList.add(a);
        System.out.println(maxAmount);
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, integerList);
        spinnerChairAmount.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View v) {

        //Er zijn stoelen geselecteerd
        Button buttonSelectChair = findViewById(R.id.buttonSelectChair);
        buttonSelectChair.setVisibility(View.VISIBLE);

        //Verkrijg ID
        int id = v.getId();

        //Kijken waar op geklikt is
        if (id == R.id.buttonSelectChair) {

            //Reserveer de seats voor in de database
            int beginSeatNumber= selectedChairIDs.get(0);
            int endSeatNumber = selectedChairIDs.get(selectedChairIDs.size() - 1);

            Seat seat = new Seat(/*rowNumber, */beginSeatNumber, endSeatNumber);

            //Laad volgende scherm
            Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
            intent.putExtra("SEAT_OBJECT", seat);
            intent.putExtra("FILM_OBJECT", film);
            startActivity(intent);

        } else {

            //Dan is het een stoel, selectie van vorige stoelen afhalen
            for (ImageView seat : seats.keySet()) {
                seat.setImageBitmap(greenChair);
            }

            //Leeg array met geselecteerde stoelen
            selectedChairIDs.clear();

            //Nummer van geselecteerde stoel verkrijgen en selecteren, ervoor zorgen dat het niet de beschikbare stoelen overschrijd
            int number = seats.get(v);
            int chairAmount = (Integer)spinnerChairAmount.getSelectedItem();
            for (int a = 0; a < chairAmount; a++)
                selectChair(number + a);

            //Creeër string
            String chairString = "";
            for (int a = 0; a < selectedChairIDs.size(); a++) {
                chairString += selectedChairIDs.get(a);
                if (a != selectedChairIDs.size() - 1)
                    chairString += ", ";
            }

            //Geselecteerde stoelnummer weergeven
            textViewChairSelected.setText(getString(R.string.seats) + " " + chairString + " " + getString(R.string.selected));
        }
    }

    private void getSeats() {

        //Bestelde stoelen van de database verkrijgen
        ArrayList<Ticket> orderedTickets = database.getTicketsByFilmTitle(film.getName());
        orderedSeats = new ArrayList<Integer>();
        for (Ticket ticket : orderedTickets) {
            for (int a = ticket.getBeginSeatNumber(); a <= ticket.getEndSeatNumber(); a++) {
                orderedSeats.add(a);
            }
        }

        //Creeër lijst met stoelen
        seats = new HashMap<>();
        int index = 1;
        while(true) {

            //Kijken of de stoel gereserveerd is
            if (orderedSeats.contains(index)) {

                //Maak stoel rood
                selectOrderedChair(index);

            } else {

                //Verkrijg id van de stoel
                int id = getResources().getIdentifier(CHAIR_ID_NAME + index, "id", getPackageName());

                //Verkrijg object
                ImageView seat = findViewById(id);

                //Als het NULL is zijn er geen stoelen meer
                if (seat == null) break;

                //Toevoegen aan de lijst
                seats.put(seat, index);

                //Add on click
                seat.setOnClickListener(this);
            }

            //Laatste seat
            lastSeat = index;

            //Verhoog index
            index++;
        }
    }

    private void selectChair(int number) {

        //Checken of het geen georderde chair is
        if (orderedSeats.contains(number) || selectedChairIDs.contains(number)) {

            //Volgende chair proberen
            selectChair(number + 1);

        } else if (number > lastSeat) {

            //Eerste chair proberen
            selectChair(1);

        } else {

            //Goede view krijgen
            int id = getResources().getIdentifier(CHAIR_ID_NAME + number, "id", getPackageName());
            ImageView v = findViewById(id);

            //Selectie op geselecteerde stoel zetten
            //v.setBackgroundColor(getColor(R.color.colorSelected));
            v.setImageBitmap(blueChair);
            selectedChairIDs.add(number);
        }
    }

    private void selectOrderedChair(int number) {

        //Goede view krijgen
        int id = getResources().getIdentifier(CHAIR_ID_NAME + number, "id", getPackageName());
        ImageView v = findViewById(id);

        //Als het NULL is zijn er geen stoelen meer
        if (v == null) return;

        //Selectie op geselecteerde stoel zetten
//        v.setBackgroundColor(getColor(R.color.colorOrdered));
        v.setImageBitmap(redChair);
    }
}
