package com.example.thomas.biosapp.Domain;

/**
 * Created by thomas on 27-03-18.
 */

public class Ticket {

    private String ticketID;
    private String buyerID;
    private String qrCode;
    private String filmTitel;
    private String tijd;
    private String stoelID;

    public Ticket(String ticketID, String buyerID, String qrCode, String filmTitel, String tijd, String stoelID) {
        this.ticketID = ticketID;
        this.buyerID = buyerID;
        this.qrCode = qrCode;
        this.filmTitel = filmTitel;
        this.tijd = tijd;
        this.stoelID = stoelID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getFilmTitel() {
        return filmTitel;
    }

    public void setFilmTitel(String filmTitel) {
        this.filmTitel = filmTitel;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public String getStoelID() {
        return stoelID;
    }

    public void setStoelID(String stoelID) {
        this.stoelID = stoelID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!ticketID.equals(ticket.ticketID)) return false;
        if (!buyerID.equals(ticket.buyerID)) return false;
        if (!qrCode.equals(ticket.qrCode)) return false;
        if (!filmTitel.equals(ticket.filmTitel)) return false;
        if (!tijd.equals(ticket.tijd)) return false;
        return stoelID.equals(ticket.stoelID);
    }

    @Override
    public int hashCode() {
        int result = ticketID.hashCode();
        result = 31 * result + buyerID.hashCode();
        result = 31 * result + qrCode.hashCode();
        result = 31 * result + filmTitel.hashCode();
        result = 31 * result + tijd.hashCode();
        result = 31 * result + stoelID.hashCode();
        return result;
    }
}
