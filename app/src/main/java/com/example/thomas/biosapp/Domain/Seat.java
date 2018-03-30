package com.example.thomas.biosapp.Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by thomas on 27-03-18.
 */

public class Seat implements Serializable{

    private int rowNumber;
    private int beginSeatNumber;
    private int endsSeatNumber;

    public Seat(int rowNumber, int beginSeatNumber, int endsSeatNumber) {
        this.rowNumber = rowNumber;
        this.beginSeatNumber = beginSeatNumber;
        this.endsSeatNumber = endsSeatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getBeginSeatNumber() {
        return beginSeatNumber;
    }

    public void setBeginSeatNumber(int beginSeatNumber) {
        this.beginSeatNumber = beginSeatNumber;
    }

    public int getEndsSeatNumber() {
        return endsSeatNumber;
    }

    public void setEndsSeatNumber(int endsSeatNumber) {
        this.endsSeatNumber = endsSeatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowNumber == seat.rowNumber &&
                beginSeatNumber == seat.beginSeatNumber &&
                endsSeatNumber == seat.endsSeatNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rowNumber, beginSeatNumber, endsSeatNumber);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "rowNumber=" + rowNumber +
                ", beginSeatNumber=" + beginSeatNumber +
                ", endsSeatNumber=" + endsSeatNumber +
                '}';
    }
}
