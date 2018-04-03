package com.example.thomas.biosapp.Controllers.Payments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thomas.biosapp.Controllers.Tickets.TicketsActivity;
import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Seat;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewPayPal;
    private ImageView imageViewIDeal;
    private TextView textViewBank;
    private Spinner spinnerBank;
    private Seat seat;
    private Film film;
    private TicketDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Verkrijg afbeeldingen, spinner en buttons
        imageViewPayPal = findViewById(R.id.imageViewPayPal);
        imageViewIDeal = findViewById(R.id.imageViewIDeal);
        spinnerBank = findViewById(R.id.spinnerBank);
        textViewBank = findViewById(R.id.textViewBank);
        Button buttonConfirmPayment = findViewById(R.id.buttonConfirmPayment);
        Button buttonCancelPayment = findViewById(R.id.buttonCancelPayment);

        //Clicklisteners toevoegen
        imageViewPayPal.setOnClickListener(this);
        imageViewIDeal.setOnClickListener(this);
        buttonConfirmPayment.setOnClickListener(this);
        buttonCancelPayment.setOnClickListener(this);

        //Gegevens aan spinner toevoegen
        String[] spinnerTitles = new String[] {"ABN AMRO", "ASN Bank", "bunq", "ING", "Knab", "Rabobank", "RegioBank","SNS", "Triodos Bank", "Van Lanschot"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerTitles);
        spinnerBank.setAdapter(spinnerAdapter);

        //Eerste payment methode weergeven
        onClick(imageViewPayPal);

        //Serializeble verkrijgen
        Intent intent = getIntent();
        seat = (Seat) intent.getSerializableExtra("SEAT_OBJECT");
        film = (Film) intent.getSerializableExtra("FILM_OBJECT");

    }

    @Override
    public void onClick(View v) {

        //Kijken op wat er is geklikt
        switch (v.getId()) {
            case R.id.imageViewPayPal:

                //Geen bank spinner en goede icoon selecteren
                textViewBank.setVisibility(View.INVISIBLE);
                spinnerBank.setVisibility(View.INVISIBLE);
                imageViewPayPal.setBackgroundColor(getColor(R.color.colorSelected));
                imageViewIDeal.setBackgroundColor(getColor(R.color.colorTransparent));
                break;

            case R.id.imageViewIDeal:

                //Bank spinner en goede icoon selecteren
                textViewBank.setVisibility(View.VISIBLE);
                spinnerBank.setVisibility(View.VISIBLE);
                imageViewPayPal.setBackgroundColor(getColor(R.color.colorTransparent));
                imageViewIDeal.setBackgroundColor(getColor(R.color.colorSelected));
                break;

            case R.id.buttonConfirmPayment:

                //Zet alle gegevens in de database
                database = new TicketDatabase(this);

                //int rowNumber = seat.getRowNumber();
                int beginSeatNumber = seat.getBeginSeatNumber();
                int endSeatNumber = seat.getEndsSeatNumber();

                String filmName = film.getName();
                String runtime = "11 uur";
                String qrCode = "qrcode";

                String posterURL = film.getPosterUrl();

                Ticket ticket = new Ticket(beginSeatNumber , endSeatNumber, filmName, runtime, qrCode, posterURL);

                database.buyTicket(film, ticket);

                //Naar de volgende activiteit, verwijder vorige activiteiten zodat de gebruiker niet terug naar de betaling kan
                Intent intent = new Intent(getApplicationContext(), TicketsActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonCancelPayment:

                //Terug
                finish();
                break;
        }
    }
}
