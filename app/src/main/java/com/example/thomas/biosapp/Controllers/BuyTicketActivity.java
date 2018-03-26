package com.example.thomas.biosapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thomas.biosapp.R;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener{

    Button buyTicketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        buyTicketButton = (Button) findViewById(R.id.buyTicketButton);
        buyTicketButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //Reserveren
        Toast.makeText(BuyTicketActivity.this, "Reserveren", Toast.LENGTH_SHORT).show();

    }
}
