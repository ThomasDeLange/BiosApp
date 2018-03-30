package com.example.thomas.biosapp.Controllers.Unused;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.thomas.biosapp.Controllers.Main.MainActivity;
import com.example.thomas.biosapp.R;
import com.example.thomas.biosapp.Api.OnQRCodeGenerated;
import com.example.thomas.biosapp.Api.QRCodeGeneratorTask;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class TicketViewActivity extends AppCompatActivity implements View.OnClickListener, OnQRCodeGenerated {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view_activity);

        //Verkrijg views, buttons
        Button buttonReturnMain = findViewById(R.id.buttonReturnMain);
        QRCodeGeneratorTask generator = new QRCodeGeneratorTask(getColor(R.color.qrCodePrimary), getColor(R.color.qrCodeSecondary), this);

        //Voeg acties toe
        buttonReturnMain.setOnClickListener(this);
        generator.execute("Julian");
    }

    @Override
    public void onClick(View v) {

        //Naar het hoofdscherm
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onQRCodeGenerated(Bitmap qrCode) {

        //Geef QRCode weer
        ImageView imageViewQRCode = findViewById(R.id.imageViewQRCode);
        imageViewQRCode.setImageBitmap(qrCode);
        imageViewQRCode.setVisibility(View.VISIBLE);

        //Verwijder lader
        ProgressBar progressBar = findViewById(R.id.progressBarQRCode);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
