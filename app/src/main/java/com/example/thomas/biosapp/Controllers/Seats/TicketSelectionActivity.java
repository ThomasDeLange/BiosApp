package com.example.thomas.biosapp.Controllers.Seats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.biosapp.Database.TicketDatabase;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;

/**
 * Created by steph on 3-4-2018.
 */

public class TicketSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewTicketSelection;
    private Film film;
    private Button confirmButton;
    //private ImageView ticketPoster;
    private int totalOfSeatRemaining;
    private TicketDatabase ticketDatabase;

    //Child
    private int intChildNumberOfTickets = 0;
    private TextView childNumberOfTickets;
    private ImageButton childAddButton;
    private ImageButton childDeleteButton;

    //Student
    private int intStudentNumberOfTickets = 0;
    private TextView studentNumberOfTickets;
    private ImageButton studentAddButton;
    private ImageButton studentDeleteButton;

    //Normal
    private int intNormalNumberOfTickets = 0;
    private TextView normalNumberOfTickets;
    private ImageButton normalAddButton;
    private ImageButton normalDeleteButton;

    //65plus
    private int int65plusNumberOfTickets = 0;
    private TextView _65plusNumberOfTickets;
    private ImageButton _65plusAddButton;
    private ImageButton _65plusDeleteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_selection);

        film = (Film) getIntent().getSerializableExtra("FILM_OBJECT");
        textViewTicketSelection = (TextView) findViewById(R.id.filmTicketTitle);
        textViewTicketSelection.setText(film.getName());

        //ticketPoster = (ImageView) findViewById(R.id.filmImage);

        //Picasso.get().load(film.getPosterUrl()).into(ticketPoster);

        confirmButton = (Button) findViewById(R.id.buttonConfirmTickets);
        confirmButton.setOnClickListener(this);

        ticketDatabase = new TicketDatabase(this);
        totalOfSeatRemaining = ticketDatabase.getRemaningNumberOfSeats(film.getName());

        //Child
        childNumberOfTickets = findViewById(R.id.childNumberOfTicketsView);
        childAddButton = findViewById(R.id.childAddButton);
        childDeleteButton = findViewById(R.id.childDeleteButton);
        childAddButton.setOnClickListener(this);
        childDeleteButton.setOnClickListener(this);

        //Student
        studentNumberOfTickets = findViewById(R.id.studentNumberOfTicketsView);
        studentAddButton = findViewById(R.id.studentAddButton);
        studentDeleteButton = findViewById(R.id.studentDeleteButton);
        studentAddButton.setOnClickListener(this);
        studentDeleteButton.setOnClickListener(this);

        //Normal
        normalNumberOfTickets = findViewById(R.id.normalNumberOfTicketsView);
        normalAddButton = findViewById(R.id.normalAddButton);
        normalDeleteButton = findViewById(R.id.normalDeleteButton);
        normalAddButton.setOnClickListener(this);
        normalDeleteButton.setOnClickListener(this);

        //65plus
        _65plusNumberOfTickets = findViewById(R.id._65plusNumberOfTicketsView);
        _65plusAddButton = findViewById(R.id._65PlusAddButton);
        _65plusDeleteButton = findViewById(R.id._65plusDeleteButton);
        _65plusAddButton.setOnClickListener(this);
        _65plusDeleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonConfirmTickets:
                Intent intent = new Intent(getApplicationContext(), SeatsActivity.class);
                intent.putExtra("TICKET_OBJECT", film);
                startActivity(intent);
                break;

            case R.id.childAddButton:

                childNumberOfTickets.setText(addTicket(intChildNumberOfTickets) + "");
                break;
            case R.id.childDeleteButton:

                childNumberOfTickets.setText(deleteTicket(intChildNumberOfTickets) + "");
                break;
            case R.id.studentAddButton:

                studentNumberOfTickets.setText(addTicket(intStudentNumberOfTickets) + "");
                break;
            case R.id.studentDeleteButton:

                studentNumberOfTickets.setText(deleteTicket(intStudentNumberOfTickets) + "");
                break;
            case R.id.normalAddButton:

                normalNumberOfTickets.setText(addTicket(intNormalNumberOfTickets) + "");
                break;
            case R.id.normalDeleteButton:

                normalNumberOfTickets.setText(deleteTicket(intNormalNumberOfTickets) + "");
                break;
            case R.id._65PlusAddButton:

                _65plusNumberOfTickets.setText(addTicket(int65plusNumberOfTickets) + "");
                break;
            case R.id._65plusDeleteButton:

                _65plusNumberOfTickets.setText(deleteTicket(int65plusNumberOfTickets) + "");
                break;

            default:
                break;
        }
    }

    public int addTicket(int a) {

        if (totalOfSeatRemaining > 0) {
            totalOfSeatRemaining -= 1;
            return a++;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Er zijn geen stoelen meer over.", Toast.LENGTH_LONG);
            toast.show();
            return a;
        }
    }

    public int deleteTicket(int a) {
        if (a > 0) {
            totalOfSeatRemaining += 1;
            return a--;
        } else {
            return 0;
        }
    }
}
