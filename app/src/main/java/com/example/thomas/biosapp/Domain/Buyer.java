package com.example.thomas.biosapp.Domain;

import java.io.Serializable;

/**
 * Created by thomas on 27-03-18.
 */

public class Buyer implements Serializable {

    private int buyerID;
    private String firstName;

    public Buyer(String firstName) {
        this.firstName = firstName;
    }

    public Buyer(int buyerID, String firstName) {
        this.buyerID = buyerID;
        this.firstName = firstName;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Buyer) o;

        if (buyerID != buyer.buyerID) return false;
        return firstName.equals(buyer.firstName);
    }

    @Override
    public int hashCode() {
        int result = buyerID;
        result = 31 * result + firstName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerID=" + buyerID +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
