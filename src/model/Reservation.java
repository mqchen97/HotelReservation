package model;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private IRoom room;
    private Customer customer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    public Reservation(IRoom room, Customer customer, LocalDate checkInDate, LocalDate checkOutDate){

        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
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
