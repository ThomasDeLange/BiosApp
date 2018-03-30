package com.example.thomas.biosapp.Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by thomas on 27-03-18.
 */

public class Ticket implements Serializable{

    private int rownumber;
    private int beginSeatNumber;
    private int endSeatNumber;
    private String filmTitle;
    private String runTime;
    private String qRCode;
    private String posterURL;



    public Ticket(int rownumber, int beginSeatNumber, int endSeatNumber, String filmTitle, String runTime, String qRCode, String posterURL) {
        this.rownumber = rownumber;
        this.beginSeatNumber = beginSeatNumber;
        this.endSeatNumber = endSeatNumber;
        this.filmTitle = filmTitle;
        this.runTime = runTime;
        this.qRCode = qRCode;
        this.posterURL = posterURL;
    }

    public int getRownumber() {
        return rownumber;
    }

    public void setRownumber(int rownumber) {
        this.rownumber = rownumber;
    }

    public int getBeginSeatNumber() {
        return beginSeatNumber;
    }

    public void setBeginSeatNumber(int beginSeatNumber) {
        this.beginSeatNumber = beginSeatNumber;
    }

    public int getEndSeatNumber() {
        return endSeatNumber;
    }

    public void setEndSeatNumber(int endSeatNumber) {
        this.endSeatNumber = endSeatNumber;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getqRCode() {
        return qRCode;
    }

    public void setqRCode(String qRCode) {
        this.qRCode = qRCode;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return rownumber == ticket.rownumber &&
                beginSeatNumber == ticket.beginSeatNumber &&
                endSeatNumber == ticket.endSeatNumber &&
                Objects.equals(filmTitle, ticket.filmTitle) &&
                Objects.equals(runTime, ticket.runTime) &&
                Objects.equals(qRCode, ticket.qRCode) &&
                Objects.equals(posterURL, ticket.posterURL);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rownumber, beginSeatNumber, endSeatNumber, filmTitle, runTime, qRCode, posterURL);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "rownumber=" + rownumber +
                ", beginSeatNumber=" + beginSeatNumber +
                ", endSeatNumber=" + endSeatNumber +
                ", filmTitle='" + filmTitle + '\'' +
                ", runTime='" + runTime + '\'' +
                ", qRCode='" + qRCode + '\'' +
                ", posterURL='" + posterURL + '\'' +
                '}';
    }
}
