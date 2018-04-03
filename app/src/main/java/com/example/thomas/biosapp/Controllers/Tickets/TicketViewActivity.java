package com.example.thomas.biosapp.Controllers.Tickets;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Controllers.Main.MainActivity;
import com.example.thomas.biosapp.Domain.Ticket;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.QRCodeGenerator;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class TicketViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Ticket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        //Verkrijg ticket
        ticket = (Ticket)getIntent().getSerializableExtra("TICKET_OBJECT");

        //Verkrijg views, buttons
        Button buttonReturnMain = findViewById(R.id.buttonReturnMain);
        TextView textViewTicketSeatRange = findViewById(R.id.textViewTicketSeatRange);
        TextView textViewTicketMovieTitle = findViewById(R.id.textViewTicketMovieTitle);
        TextView textViewTicketMovieTime = findViewById(R.id.textViewTicketMovieTime);
        ImageView imageViewQRCode = findViewById(R.id.imageViewQRCode);
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator(getColor(R.color.qrCodePrimary), getColor(R.color.qrCodeSecondary));

        //Voeg acties toe
        buttonReturnMain.setOnClickListener(this);
        Bitmap qrCode = qrCodeGenerator.generate(ticket.getFilmTitle() + ticket.getBeginSeatNumber());
        imageViewQRCode.setImageBitmap(qrCode);

        //Voer gegevens in
        textViewTicketSeatRange.setText(getString(R.string.chair) + " " + ticket.getBeginSeatNumber() + " - " + ticket.getEndSeatNumber());
        textViewTicketMovieTitle.setText(ticket.getFilmTitle());
        textViewTicketMovieTime.setText("11 uur");
    }

    @Override
    public void onClick(View v) {

        //Naar het hoofdscherm
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
