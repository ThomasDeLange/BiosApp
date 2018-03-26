package com.example.thomas.biosapp.Controllers;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.thomas.biosapp.R;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Verkrijg button en actie toevoegen
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        //Views ophalen
        RatingBar ratingBarCinema = findViewById(R.id.ratingBarCinema);
        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextEmailadres = findViewById(R.id.editTextEmailadres);
        EditText editTextMessage = findViewById(R.id.editTextMessage);

        //Gegevens verkrijgen
        float rating = ratingBarCinema.getRating();
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String emailadres = editTextEmailadres.getText().toString();
        String message = editTextMessage.getText().toString();

        //Gegevens weergeven
        Toast.makeText(this, firstName + "\n" + lastName + "\n" + emailadres + "\n" + message + "\n" + rating, Toast.LENGTH_SHORT).show();
    }
}
