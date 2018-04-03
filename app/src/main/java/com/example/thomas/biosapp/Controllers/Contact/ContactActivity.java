package com.example.thomas.biosapp.Controllers.Contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact_old);

        //Verkrijg buttons
        Button buttonRoute = findViewById(R.id.buttonRoute);
        Button buttonFeedback = findViewById(R.id.buttonFeedback);

        //Clicklisteners toevoegen
        buttonRoute.setOnClickListener(this);
        buttonFeedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Cast
        Button button = (Button) v;
        Intent intent;

        //Kijken welke knop het is
        if (button.getText().equals(getString(R.string.route))) {

            //Routebeschrijving
            intent = new Intent(getApplicationContext(), MapsActivity.class);

        } else if (button.getText().equals(getString(R.string.feedback_geven))) {

            //Nepfilm aan maken om de feedback activity te laten geloven dat het om de bioscoop gaat
            Film film = null;

            //Feedback geven
            intent = new Intent(getApplicationContext(), FeedbackActivity.class);
            intent.putExtra("FILM_OBJECT", film);

        } else return;

        //Start intent
        startActivity(intent);
    }
}
