package com.example.thomas.biosapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thomas.biosapp.R;

public class PaymentMethodActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewPayPal;
    private ImageView imageViewIDeal;
    private TextView textViewBank;
    private Spinner spinnerBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        //Verkrijg afbeeldingen, spinner en buttons
        imageViewPayPal = findViewById(R.id.imageViewPayPal);
        imageViewIDeal = findViewById(R.id.imageViewIDeal);
        spinnerBank = findViewById(R.id.spinnerBank);
        textViewBank = findViewById(R.id.textViewBank);
        Button buttonConfirmPayment = findViewById(R.id.buttonConfirmPayment);
        Button buttonCancelPayment = findViewById(R.id.buttonCancelPayment);

        //Clicklisteners toevoegen
        imageViewPayPal.setOnClickListener(this);
        imageViewIDeal.setOnClickListener(this);
        buttonConfirmPayment.setOnClickListener(this);
        buttonCancelPayment.setOnClickListener(this);

        //Gegevens aan spinner toevoegen
        String[] spinnerTitles = new String[] {"ABM AMRO", "ASN Bank", "bunq", "ING", "Knab", "Rabobank", "RegioBank","SNS", "Triodos Bank", "Van Lanschot"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerTitles);
        spinnerBank.setAdapter(spinnerAdapter);

        //Eerste payment methode weergeven
        onClick(imageViewPayPal);
    }

    @Override
    public void onClick(View v) {

        //Kijken op wat er is geklikt
        switch (v.getId()) {
            case R.id.imageViewPayPal:

                //Geen bank spinner en goede icoon selecteren
                textViewBank.setVisibility(View.INVISIBLE);
                spinnerBank.setVisibility(View.INVISIBLE);
                imageViewPayPal.setBackgroundColor(getColor(R.color.colorSelected));
                imageViewIDeal.setBackgroundColor(getColor(R.color.colorTransparent));
                break;

            case R.id.imageViewIDeal:

                //Bank spinner en goede icoon selecteren
                textViewBank.setVisibility(View.VISIBLE);
                spinnerBank.setVisibility(View.VISIBLE);
                imageViewPayPal.setBackgroundColor(getColor(R.color.colorTransparent));
                imageViewIDeal.setBackgroundColor(getColor(R.color.colorSelected));
                break;

            case R.id.buttonConfirmPayment:

                //Naar de volgende activiteit, verwijder vorige activiteiten zodat de gebruiker niet terug naar de betaling kan
                Intent intent = new Intent(getApplicationContext(), PaymentProgressActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonCancelPayment:

                //Terug
                finish();
                break;
        }
    }
}
