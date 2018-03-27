package com.example.thomas.biosapp.Api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thomas.biosapp.R;

import java.util.ArrayList;

public class SeatsActivity extends AppCompatActivity {

    private ArrayList<ImageView> seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        //Create list
        seats = new ArrayList<ImageView>();

        //Go through all seats
        for (int i = 1; i <= 52; i++) {

            try {

                //Verkrijg id van de stoel
                int id = getResources().getIdentifier("selectableChair" + i, "id", getPackageName());

                //Verkrijg object
                ImageView seat = findViewById(id);

                //Toevoegen aan de lijst
                seats.add(seat);

                //Add on click
                seat.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SeatsActivity.this, "Seat ", Toast.LENGTH_LONG).show();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
