package com.example.thomas.biosapp.Controllers.Unused;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thomas.biosapp.Controllers.Seats.SeatsActivity;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.TicketDataValidator;

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

        //String krijgen
        String firstName = editTextTicketsFirstName.getText().toString();
        String lastName = editTextTicketsLastName.getText().toString();

        //Data valideren
        TicketDataValidator ticketDataValidator = new TicketDataValidator(this);
        if (ticketDataValidator.validate(firstName, lastName)) {

            //Naar volgende scherm
            Intent intent = new Intent(getApplicationContext(), SeatsActivity.class);
            //intent.putExtra("FILM_OBJECT", film);
            startActivity(intent);
        }
    }
}
