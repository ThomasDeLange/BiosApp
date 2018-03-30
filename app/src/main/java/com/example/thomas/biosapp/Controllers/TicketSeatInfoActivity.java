package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.thomas.biosapp.Database.TicketDatabase.TicketDatabase;
import com.example.thomas.biosapp.Domain.Buyer;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Seat;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketSeatInfoActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "TicketSeatInfoActivity";

    Buyer buyer;
    Film film;

    Button proceedButton;

    Spinner rowNumberSpinner;
    Spinner seatNumberSpinner;

    SpinnerAdapter spinnerAdapter;
    int numberOfTickets;

    ArrayList<String> spinnerInput;

    int rowNumber;
    int seatNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_seat_info);

        buyer = (Buyer) getIntent().getSerializableExtra("BUYER_OBJECT");
        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");

        proceedButton = findViewById(R.id.payButton);
        proceedButton.setOnClickListener(this);

        seatNumberSpinner = findViewById(R.id.seatNumberSpinner);
        rowNumberSpinner = findViewById(R.id.rowNumberSpinner);

        spinnerInput = new ArrayList<>();
        spinnerInput.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        spinnerAdapter = new ArrayAdapter<String>(TicketSeatInfoActivity.this, android.R.layout.simple_spinner_item, spinnerInput);

        seatNumberSpinner.setAdapter(spinnerAdapter);
        rowNumberSpinner.setAdapter(spinnerAdapter);

        seatNumberSpinner.setOnItemSelectedListener(this);
        rowNumberSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

        Ticket ticket = new Ticket(4, 3, 5, film.getName(), "11 uur", "qrcode");

        TicketDatabase database = new TicketDatabase(getApplicationContext());
        database.buyTicket(film, ticket);

        database.printTickets();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()) {

            case R.id.seatNumberSpinner:
                Log.d(TAG, "seatnumber: " + seatNumber);

                seatNumber = Integer.parseInt((String)seatNumberSpinner.getSelectedItem());
                break;

            case R.id.rowNumberSpinner:
                Log.d(TAG, "seatnumber: " + rowNumber);

                rowNumber = Integer.parseInt((String)seatNumberSpinner.getSelectedItem());
                break;

            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
