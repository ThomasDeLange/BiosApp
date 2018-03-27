package com.example.thomas.biosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thomas.biosapp.Controllers.PaymentMethodActivity;
import com.example.thomas.biosapp.Controllers.SeatsActivity;

public class TicketsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextTicketsFirstName;
    private EditText editTextTicketsLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        //Verkrijg views
        editTextTicketsFirstName = findViewById(R.id.editTextTicketsFirstName);
        editTextTicketsLastName = findViewById(R.id.editTextTicketsLastName);
        Button buttonConfirmTicketData = findViewById(R.id.buttonConfirmTicketData);

        //Listener toevoegen
        buttonConfirmTicketData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Naar volgende scherm
        Intent intent = new Intent(getApplicationContext(), SeatsActivity.class);
        //intent.putExtra("FILM_OBJECT", film);
        startActivity(intent);
    }
}
