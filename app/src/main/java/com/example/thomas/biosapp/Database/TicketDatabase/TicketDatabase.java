package com.example.thomas.biosapp.Database.TicketDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by thomas on 26-03-18.
 */

public class TicketDatabase extends SQLiteOpenHelper {

    private final static String TAG = "TicketDatabase";


    private final static String DB_NAME = "TicketDatabse.db";
    private final static int DB_VERSION = 0;

    private final static String TICKET_TABLE_NAME = "Ticket";

    private final static String TICKET_TICKET_ID = "TicketID";
    private final static String TICKET_BUYER_ID = "BuyerID";
    private final static String TICKET_QR_CODE = "QRCode";
    private final static String TICKET_FILM_TITLE = "FilmTitel";
    private final static String TICKET_RUN_TIME = "RunTime";
    private final static String TICKET_SEAT_ID = "SeatID";

    private final static String SEAT_TABLE_NAME = "Seat";

    private final static String SEAT_SEAT_ID = "SeatID";
    private final static String SEAT_ROW_NUMBER = "RowNumber";
    private final static String SEAT_SEAT_NUMBER = "SeatNumber";

    private final static String BUYER_TABLE_NAME = "Buyer";

    private final static String BUYER_BUYER_ID = "BuyerID";
    private final static String BUYER_FIRST_NAME = "FirstName";

    public TicketDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `" + TICKET_TABLE_NAME + "` ( `" + TICKET_TICKET_ID + "` INTEGER NOT NULL, `" + TICKET_BUYER_ID + "` INTEGER NOT NULL, `" + TICKET_QR_CODE + "` TEXT NOT NULL, `" + TICKET_FILM_TITLE + "` TEXT NOT NULL, `" + TICKET_RUN_TIME + "` TEXT NOT NULL, `" + TICKET_SEAT_ID + "` INTEGER NOT NULL, FOREIGN KEY(`" + TICKET_BUYER_ID + "`) REFERENCES `" + BUYER_TABLE_NAME + "`(`" + BUYER_BUYER_ID + "`) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY(`" + TICKET_SEAT_ID + "`) REFERENCES `" + SEAT_TABLE_NAME + "`(`" + SEAT_SEAT_ID + "`) ON UPDATE CASCADE ON DELETE CASCADE, PRIMARY KEY(`" + TICKET_TICKET_ID + "`) )");
        sqLiteDatabase.execSQL("CREATE TABLE `" + BUYER_TABLE_NAME + "` ( `" + BUYER_BUYER_ID + "` INTEGER NOT NULL, `" + BUYER_FIRST_NAME + "` TEXT NOT NULL, FOREIGN KEY(`" + BUYER_BUYER_ID + "`) REFERENCES `" + TICKET_TABLE_NAME + "`(`" + BUYER_BUYER_ID + "`) )");
        sqLiteDatabase.execSQL("CREATE TABLE `" + SEAT_TABLE_NAME + "` ( `" + SEAT_SEAT_ID + "` INTEGER NOT NULL, `" + SEAT_ROW_NUMBER + "` INTEGER NOT NULL, `" + SEAT_SEAT_NUMBER + "` INTEGER NOT NULL, PRIMARY KEY(`" + SEAT_SEAT_ID + "`) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade: upgrading database.");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BUYER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SEAT_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKET_TABLE_NAME);

        this.onCreate(sqLiteDatabase);
    }
}
