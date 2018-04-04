package com.example.thomas.biosapp.Controllers.Contact;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thomas.biosapp.Controllers.Contact.FeedbackActivity;
import com.example.thomas.biosapp.Controllers.Contact.MapsActivity;
import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;

/**
 * Created by steph on 26-3-2018.
 */

public class ContactFragment extends Fragment implements View.OnClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //View
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        //Verkrijg buttons;
        Button buttonRoute = view.findViewById(R.id.buttonRoute);
        Button buttonFeedback = view.findViewById(R.id.buttonFeedback);

        //Clicklisteners toevoegen
        buttonRoute.setOnClickListener(this);
        buttonFeedback.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {

        //Cast
        Button button = (Button)v;
        Intent intent;

        //Kijken welke knop het is
        if (button.getText().equals(getString(R.string.route))) {

            //Routebeschrijving
            intent = new Intent(getContext(), MapsActivity.class);

        } else if (button.getText().equals(getString(R.string.feedback_geven))) {

            //Nepfilm aan maken om de feedback activity te laten geloven dat het om de bioscoop gaat
            Film film = null;

            //Feedback geven
            intent = new Intent(getContext(), FeedbackActivity.class);
            intent.putExtra("FILM_OBJECT", film);

        } else return;

        //Start intent
        startActivity(intent);
    }
}
