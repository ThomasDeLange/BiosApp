package com.example.thomas.biosapp.Domain;

/**
 * Created by thomas on 27-03-18.
 */

public class Ticket {

    private String ticketID;
    private String buyerID;
    private String qrCode;
    private String filmTitle;
    private String runTime;
    private String seatId;

    public Ticket(String qrCode, String runTime) {
        this.qrCode = qrCode;
        this.runTime = runTime;
    }

    public Ticket(String ticketID, String buyerID, String qrCode, String filmTitle, String runTime, String seatId) {
        this.ticketID = ticketID;
        this.buyerID = buyerID;
        this.qrCode = qrCode;
        this.filmTitle = filmTitle;
        this.runTime = runTime;
        this.seatId = seatId;
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
        return filmTitle;
    }

    public void setFilmTitel(String filmTitel) {
        this.filmTitle = filmTitel;
    }

    public String getrunTime() {
        return runTime;
    }

    public void setrunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getseatId() {
        return seatId;
    }

    public void setseatId(String seatId) {
        this.seatId = seatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!ticketID.equals(ticket.ticketID)) return false;
        if (!buyerID.equals(ticket.buyerID)) return false;
        if (!qrCode.equals(ticket.qrCode)) return false;
        if (!filmTitle.equals(ticket.filmTitle)) return false;
        if (!runTime.equals(ticket.runTime)) return false;
        return seatId.equals(ticket.seatId);
    }

    @Override
    public int hashCode() {
        int result = ticketID.hashCode();
        result = 31 * result + buyerID.hashCode();
        result = 31 * result + qrCode.hashCode();
        result = 31 * result + filmTitle.hashCode();
        result = 31 * result + runTime.hashCode();
        result = 31 * result + seatId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", buyerID='" + buyerID + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", filmTitle='" + filmTitle + '\'' +
                ", runTime='" + runTime + '\'' +
                ", seatId='" + seatId + '\'' +
                '}';
    }
}
