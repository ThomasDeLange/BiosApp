package com.example.thomas.biosapp.Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by thomas on 27-03-18.
 */

public class Seat implements Serializable{

    private int beginSeatNumber;
    private int endsSeatNumber;

    public Seat(int beginSeatNumber, int endsSeatNumber) {
        this.beginSeatNumber = beginSeatNumber;
        this.endsSeatNumber = endsSeatNumber;
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
}
