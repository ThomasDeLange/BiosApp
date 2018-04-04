package com.example.thomas.biosapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.Domain.Ticket;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by thomas on 26-03-18.
 */

public class TicketDatabase extends SQLiteOpenHelper implements Serializable {

    private final static String TAG = "TicketDatabase";

    private final static String DB_NAME = "TicketDatabse.db";
    private final static int DB_VERSION = 10;

    private final static String TICKET_TABLE_NAME = "Ticket";

    private final static String TICKET_BEGIN_SEATNUMBER = "BeginSeatNumber";
    private final static String TICKET_END_SEATNUMBER = "EndSeatNumber";
    private final static String TICKET_FILM_TITLE = "FilmTitle";
    private final static String TICKET_RUN_TIME = "RunTime";
    private final static String TICKET_QR_CODE = "QRCode";
    private final static String TICKET_POSTER_URL = "PosterURL";

    public TicketDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `"+TICKET_TABLE_NAME +"` (" +
                "`"+TICKET_BEGIN_SEATNUMBER +"` INTEGER NOT NULL," +
                "`"+TICKET_END_SEATNUMBER +"` INTEGER NOT NULL," +
                "`"+TICKET_FILM_TITLE +"` TEXT NOT NULL," +
                "`"+TICKET_RUN_TIME +"` TEXT NOT NULL," +
                "`"+TICKET_QR_CODE +"` TEXT NOT NULL," +
                "`"+TICKET_POSTER_URL +"` TEXT NOT NULL" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade: upgrading database.");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKET_TABLE_NAME);

        this.onCreate(sqLiteDatabase);
    }

    public void buyTicket(Film film, Ticket ticket) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues ticketValues = new ContentValues();
        ticketValues.put(TICKET_BEGIN_SEATNUMBER, ticket.getBeginSeatNumber());
        ticketValues.put(TICKET_END_SEATNUMBER, ticket.getEndSeatNumber());
        ticketValues.put(TICKET_FILM_TITLE, film.getName());
        ticketValues.put(TICKET_RUN_TIME, ticket.getRunTime());
        ticketValues.put(TICKET_QR_CODE, ticket.getqRCode());
        ticketValues.put(TICKET_POSTER_URL, ticket.getPosterURL());

        database.insert(TICKET_TABLE_NAME, null, ticketValues);

        database.close();
    }

    public ArrayList<Ticket> getTicketsByFilmTitle(String filmTitle) {
        return getTickets("SELECT * FROM " + TICKET_TABLE_NAME + " WHERE " + TICKET_FILM_TITLE + " = '" + filmTitle + "'"  + " ORDER BY " + TICKET_BEGIN_SEATNUMBER);
    }

    public ArrayList<Ticket> getAllTickets() {
        return getTickets("SELECT * FROM " + TICKET_TABLE_NAME);
    }

    private ArrayList<Ticket> getTickets(String query){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        ArrayList<Ticket> ticketArrayList = new ArrayList<>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int beginSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_BEGIN_SEATNUMBER));
            int endSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_END_SEATNUMBER));
            String filmTitle = cursor.getString(cursor.getColumnIndex(TICKET_FILM_TITLE));
            String runTime = cursor.getString(cursor.getColumnIndex(TICKET_RUN_TIME));
            String qrCode = cursor.getString(cursor.getColumnIndex(TICKET_QR_CODE));
            String posterURL = cursor.getString(cursor.getColumnIndex(TICKET_POSTER_URL));


            ticketArrayList.add(new Ticket(beginSeatNumber, endSeatNumber, filmTitle, runTime, qrCode, posterURL));
            cursor.moveToNext();
        }

        return ticketArrayList;
    }

    public int getRemaningNumberOfSeats(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT " + TICKET_BEGIN_SEATNUMBER + ", " + TICKET_END_SEATNUMBER +" FROM " + TICKET_TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);

        int totalReserved = 0;
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int beginSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_BEGIN_SEATNUMBER));
            int endSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_END_SEATNUMBER));

            totalReserved += endSeatNumber - beginSeatNumber + 1;

            cursor.moveToNext();
        }


        return 54 - totalReserved;
    }


//    public void printTickets() {
//
//        SQLiteDatabase database = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + TICKET_TABLE_NAME;
//        Cursor cursor = database.rawQuery(query, null);
//
//        ArrayList<Ticket> ticketArrayList = new ArrayList<>();
//
//        cursor.moveToFirst();
//
//        while (!cursor.isAfterLast()) {
//            int beginSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_BEGIN_SEATNUMBER));
//            int endSeatNumber = cursor.getInt(cursor.getColumnIndex(TICKET_END_SEATNUMBER));
//            String filmTitle = cursor.getString(cursor.getColumnIndex(TICKET_FILM_TITLE));
//            String runTime = cursor.getString(cursor.getColumnIndex(TICKET_RUN_TIME));
//            String qrCode = cursor.getString(cursor.getColumnIndex(TICKET_QR_CODE));
//            String posterURL = cursor.getString(cursor.getColumnIndex(TICKET_POSTER_URL));
//
//
//            ticketArrayList.add(new Ticket(beginSeatNumber, endSeatNumber, filmTitle, runTime, qrCode, posterURL));
//            cursor.moveToNext();
//        }
//        cursor.close();
//        database.close();
//        for (Ticket t : ticketArrayList) {
//            Log.i(TAG, t.toString());
//
//        }
//    }







}
