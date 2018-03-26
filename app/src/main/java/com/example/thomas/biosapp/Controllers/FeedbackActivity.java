package com.example.thomas.biosapp.Controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Util.FeedbackValidator;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Verkrijg title
        Film film = (Film)getIntent().getSerializableExtra("FILM_OBJECT");
        String title = getString(R.string.activity_feedback) + " " + (film == null ? getString(R.string.cinema) : film.getName());

        //Plaats title
        TextView textViewContact = findViewById(R.id.textViewFeedback);
        textViewContact.setText(title);

        //Verkrijg button en actie toevoegen
        Button button = findViewById(R.id.buttonSendFeedback);
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

        //Controleren of alle gegevens kloppen
        FeedbackValidator validator = new FeedbackValidator(this);
        if (validator.validate(rating, firstName, lastName, emailadres, message)) {

            //Window maken met popup
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.feedback_message_title));
            builder.setMessage(getString(R.string.feedback_message_content));
            builder.setPositiveButton(R.string.ok, this);
            AlertDialog dialog = builder.create();

            //Popup weergeven en activiteit eindigen
            dialog.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        //Venster OK geklikt
        finish();
    }
}
