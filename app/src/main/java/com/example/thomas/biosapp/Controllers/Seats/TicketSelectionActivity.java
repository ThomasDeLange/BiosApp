package com.example.thomas.biosapp.Controllers.Seats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
    private int totalOfSeatRemaining;
    private TicketDatabase ticketDatabase;

    private TextView priceView;

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

        confirmButton = (Button) findViewById(R.id.buttonConfirmTickets);
        confirmButton.setOnClickListener(this);

        ticketDatabase = new TicketDatabase(this);
        totalOfSeatRemaining = ticketDatabase.getRemaningNumberOfSeats(film.getName());

        priceView = findViewById(R.id.priceView);

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
                intent.putExtra("totalNumberOfChairs", int65plusNumberOfTickets + intChildNumberOfTickets + intNormalNumberOfTickets + intStudentNumberOfTickets);
                intent.putExtra("totalPrice", intChildNumberOfTickets * 5 + intStudentNumberOfTickets * 7.5 + intNormalNumberOfTickets * 20 + int65plusNumberOfTickets * 15 + "$");
                startActivity(intent);

                break;

            case R.id.childAddButton:

                intChildNumberOfTickets = addTicket(intChildNumberOfTickets);
                childNumberOfTickets.setText(intChildNumberOfTickets + "");
                updatePrice();
                break;
            case R.id.childDeleteButton:

                intChildNumberOfTickets = deleteTicket(intChildNumberOfTickets);
                childNumberOfTickets.setText(intChildNumberOfTickets + "");
                updatePrice();

                break;
            case R.id.studentAddButton:

                intStudentNumberOfTickets = addTicket(intStudentNumberOfTickets);
                studentNumberOfTickets.setText(intStudentNumberOfTickets + "");
                updatePrice();

                break;
            case R.id.studentDeleteButton:

                intStudentNumberOfTickets = deleteTicket(intStudentNumberOfTickets);
                studentNumberOfTickets.setText(intStudentNumberOfTickets + "");
                updatePrice();

                break;
            case R.id.normalAddButton:

                intNormalNumberOfTickets = addTicket(intNormalNumberOfTickets);
                normalNumberOfTickets.setText(intNormalNumberOfTickets + "");
                updatePrice();

                break;
            case R.id.normalDeleteButton:

                intNormalNumberOfTickets = deleteTicket(intNormalNumberOfTickets);
                normalNumberOfTickets.setText(intNormalNumberOfTickets + "");
                updatePrice();

                break;
            case R.id._65PlusAddButton:

                int65plusNumberOfTickets = addTicket(int65plusNumberOfTickets);
                _65plusNumberOfTickets.setText(int65plusNumberOfTickets + "");
                updatePrice();

                break;
            case R.id._65plusDeleteButton:

                int65plusNumberOfTickets = deleteTicket(int65plusNumberOfTickets);
                _65plusNumberOfTickets.setText(int65plusNumberOfTickets + "");
                updatePrice();

                break;

            default:
                break;
        }
    }

    public int addTicket(int a) {

        if (totalOfSeatRemaining > 0) {
            totalOfSeatRemaining -= 1;

            return ++a;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Er zijn geen stoelen meer over.", Toast.LENGTH_SHORT);
            toast.show();
            return a;
        }
    }

    public int deleteTicket(int a) {
        if (a > 0) {
            totalOfSeatRemaining += 1;

            return --a;
        } else {
            return 0;
        }
    }

    public void updatePrice() {
        priceView.setText(intChildNumberOfTickets * 5 + intStudentNumberOfTickets * 7.5 + intNormalNumberOfTickets * 20 + int65plusNumberOfTickets * 15 + "$");
    }

}
