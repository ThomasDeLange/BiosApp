package com.example.thomas.biosapp.Controllers;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.biosapp.R;

/**
 * Created by steph on 26-3-2018.
 */

public class TicketOverviewFragment extends Fragment {

    public TicketOverviewFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_old, container, false);
    }

}
