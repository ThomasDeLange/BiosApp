package com.example.thomas.biosapp.Controllers.Unused;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.thomas.biosapp.Controllers.Main.MainActivity;
import com.example.thomas.biosapp.Controllers.Tickets.TicketsActivity;
import com.example.thomas.biosapp.R;

public class PaymentFinishedActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_finished);

        //Verkrijg knoppen
        Button buttonReturnMain = findViewById(R.id.buttonReturnMain);
        Button buttonShowTicket = findViewById(R.id.buttonShowTicket);

        //Clicklistener toevoegen
        buttonReturnMain.setOnClickListener(this);
        buttonShowTicket.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //View controleren
        switch(v.getId()) {
            case R.id.buttonReturnMain:

                //Ga naar hoofdscherm
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMain);
                break;

            case R.id.buttonShowTicket:

                //Ga naar ticketscherm
                Intent intentTicket = new Intent(getApplicationContext(), TicketsActivity.class);
                startActivity(intentTicket);
                break;
        }
    }
}
