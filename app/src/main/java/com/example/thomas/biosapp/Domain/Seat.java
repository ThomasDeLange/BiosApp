package com.example.thomas.biosapp.Domain;

/**
 * Created by thomas on 27-03-18.
 */

public class Seat {

    private int seatID;
    private int rowNumber;
    private int seatNumber;

    public Seat(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public Seat(int seatID, int rowNumber, int seatNumber) {
        this.seatID = seatID;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (seatID != seat.seatID) return false;
        if (rowNumber != seat.rowNumber) return false;
        return seatNumber == seat.seatNumber;
    }

    @Override
    public int hashCode() {
        int result = seatID;
        result = 31 * result + rowNumber;
        result = 31 * result + seatNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatID=" + seatID +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
