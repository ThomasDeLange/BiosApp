package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.thomas.biosapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketBuyerInfoActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "TicketBuyerInfoActivity";

    Button proceedButton;

    TextView firstNameEditView;
    String buyername;

    SpinnerAdapter spinnerAdapter;
    Spinner numberOfTicketsSpinner;
    int numberOfTickets;

    ArrayList<String> spinnerInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_buyer_info);

        proceedButton = (Button) findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(this);

        firstNameEditView = findViewById(R.id.firstNameEditView);
        firstNameEditView.setOnEditorActionListener(this);

        numberOfTicketsSpinner = (Spinner) findViewById(R.id.numberOfTicketsSpinner);

        numberOfTicketsSpinner.setOnItemSelectedListener(this);

        spinnerInput = new ArrayList<>();
        spinnerInput.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        spinnerAdapter = new ArrayAdapter<String>(TicketBuyerInfoActivity.this, android.R.layout.simple_spinner_item, spinnerInput);

        this.numberOfTicketsSpinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TicketSeatInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        buyername = (String) firstNameEditView.getText();
        Log.i(TAG, "onEditorAction: name = " + buyername);
        return false;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        numberOfTickets = Integer.parseInt((String) numberOfTicketsSpinner.getSelectedItem());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}