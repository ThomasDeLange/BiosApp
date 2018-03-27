package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.R;

import java.util.ArrayList;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ImageView> seats;
    private TextView textViewChairSelected;
    private final String CHAIR_ID_NAME = "selectableChair";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

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
        seats = new ArrayList<ImageView>();
        int index = 1;
        while(true) {

            //Verkrijg id van de stoel
            int id = getResources().getIdentifier(CHAIR_ID_NAME + index, "id", getPackageName());

            //Verkrijg object
            ImageView seat = findViewById(id);

            //Als het NULL is zijn er geen stoelen meer
            if (seat == null) break;

            //Toevoegen aan de lijst
            seats.add(seat);

            //Add on click
            seat.setOnClickListener(this);

            //Verhoog index
            index++;
        }

        //Eerste stoel selecteren
        onClick(seats.get(0));
    }

    @Override
    public void onClick(View v) {

        //Verkrijg ID
        int id = v.getId();

        //Kijken waar op geklikt is
        if (id == R.id.buttonSelectChair) {

            //Laad volgende scherm
            Intent intent = new Intent(getApplicationContext(), PaymentMethodActivity.class);
            //intent.putExtra("FILM_OBJECT", film);
            startActivity(intent);

        } else {

            //Dan is het een stoel, selectie van vorige stoelen afhalen
            for (ImageView seat : seats) {
                seat.setBackgroundColor(getColor(R.color.colorTransparent));
            }

            //Selectie op geselecteerde stoel zetten
            v.setBackgroundColor(getColor(R.color.colorSelected));

            //Nummer van geselecteerde stoel verkrijgen
            String name = getResources().getResourceEntryName(id);
            name = name.replace(CHAIR_ID_NAME,"");
            int number = Integer.parseInt(name);

            //Geselecteerde stoelnummer weergeven
            textViewChairSelected.setText(getString(R.string.seats) + " " + number + " " + getString(R.string.selected));
        }
    }
}
