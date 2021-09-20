package model;

import java.util.Date;

public class Reservation {
    private IRoom room;
    private Customer customer;
    private Date checkInDate;
    private Date checkOutDate;
    public Reservation(IRoom room, Customer customer, Date checkInDate, Date checkOutDate){
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    @Override
    public String toString(){
        return customer + "\n" + room + "\n"
                + "Check in Date: " + checkInDate + "\n"
                + "Check out Date: " + checkOutDate;
    }
}
