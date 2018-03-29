package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thomas.biosapp.R;

public class TicketSeatInfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_seat_info);
    }

    @Override
    public void onClick(View v) {
        //Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
        //startActivity(intent);
    }
}
