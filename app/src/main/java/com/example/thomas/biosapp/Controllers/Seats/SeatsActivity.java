package com.example.thomas.biosapp.Controllers.Seats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thomas.biosapp.Controllers.Payments.PaymentMethodActivity;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {

    private HashMap<ImageView, Integer> seats;
    private TextView textViewChairSelected;
    private final String CHAIR_ID_NAME = "selectableChair";
    private ArrayList<Integer> selectedChairIDs;
    private Spinner spinnerChairAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        //Spinner
        spinnerChairAmount = findViewById(R.id.spinnerChairAmount);
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, integers);
        spinnerChairAmount.setAdapter(spinnerAdapter);

        //Chairlijst aanmaken
        selectedChairIDs = new ArrayList<Integer>();

        //Laad select text
        textViewChairSelected = findViewById(R.id.textViewChairSelected);

        //Laad selecteerknop
        Button buttonSelectChair = findViewById(R.id.buttonSelectChair);
        buttonSelectChair.setOnClickListener(this);

        //Verkrijg stoelen
        getSeats();
    }

    private void getSeats() {

        //Creeër lijst met stoelen
        seats = new HashMap<>();
        int index = 1;
        ImageView first = null;
        while(true) {

            //Verkrijg id van de stoel
            int id = getResources().getIdentifier(CHAIR_ID_NAME + index, "id", getPackageName());

            //Verkrijg object
            ImageView seat = findViewById(id);

            //Eerste opslaan
            if (index == 1) first = seat;

            //Als het NULL is zijn er geen stoelen meer
            if (seat == null) break;

            //Toevoegen aan de lijst
            seats.put(seat, index);

            //Add on click
            seat.setOnClickListener(this);

            //Verhoog index
            index++;
        }
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

            //Laad volgende scherm
            Intent intent = new Intent(getApplicationContext(), PaymentMethodActivity.class);

            Ticket ticket = new Ticket();
            ticket.setBeginSeatNumber(selectedChairIDs.get(0));
            ticket.setEndSeatNumber(selectedChairIDs.get(selectedChairIDs.size() - 1));

            //intent.putExtra("FILM_OBJECT", film);
            startActivity(intent);

        } else {

            //Dan is het een stoel, selectie van vorige stoelen afhalen
            for (ImageView seat : seats.keySet()) {
                seat.setBackgroundColor(getColor(R.color.colorTransparent));
            }

            //Leeg array met geselecteerde stoelen
            selectedChairIDs.clear();

            //Nummer van geselecteerde stoel verkrijgen en selecteren, ervoor zorgen dat het niet de beschikbare stoelen overschrijd
            int number = seats.get(v);
            int chairAmount = (Integer)spinnerChairAmount.getSelectedItem();
            if ((number + chairAmount) > seats.size())
                number = (seats.size() - chairAmount) + 1;
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

    private void selectChair(int number) {

        //Goede view krijgen
        int id = getResources().getIdentifier(CHAIR_ID_NAME + number, "id", getPackageName());
        ImageView v = findViewById(id);

        //Selectie op geselecteerde stoel zetten
        v.setBackgroundColor(getColor(R.color.colorSelected));
        selectedChairIDs.add(number);
    }
}
