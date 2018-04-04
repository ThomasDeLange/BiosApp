package com.example.thomas.biosapp.Domain;

import java.io.Serializable;

/**
 * Created by thomas on 27-03-18.
 */

public class Ticket implements Serializable {

    //private int rownumber;
    private int beginSeatNumber;
    private int endSeatNumber;
    private String filmTitle;
    private String runTime;
    private String posterURL;


    public Ticket(int beginSeatNumber, int endSeatNumber, String filmTitle, String runTime, String posterURL) {
        this.beginSeatNumber = beginSeatNumber;
        this.endSeatNumber = endSeatNumber;
        this.filmTitle = filmTitle;
        this.runTime = runTime;
        this.posterURL = posterURL;
    }

    public int getBeginSeatNumber() {
        return beginSeatNumber;
    }

    public int getEndSeatNumber() {
        return endSeatNumber;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getPosterURL() {
        return posterURL;
    }
}
