package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationService {

    private static ReservationService instance;
    private Set<Reservation> reservations = new HashSet<>();
    private Set<IRoom> rooms = new HashSet<>();

    private ReservationService(){}

    public static ReservationService getInstance(){
        if(instance == null){
            instance = new ReservationService();
        }
        return instance;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<IRoom> getRooms() {
        return rooms;
    }

    public void setRooms(Set<IRoom> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(IRoom room){
        if(rooms.contains(room)){
            System.out.println("The roomNumber already exists");
        }
        else{
            rooms.add(room);
        }
    }

    public Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate){
        Reservation reservation = new Reservation(room,customer,checkInDate,checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate){
        Collection<IRoom> exRooms = new HashSet<>(rooms);
        for(Reservation reservation : reservations){
            if((reservation.getCheckInDate().isBefore(checkInDate)&&reservation.getCheckOutDate().isAfter(checkInDate))
            ||(reservation.getCheckInDate().isBefore(checkOutDate)&&reservation.getCheckOutDate().isAfter(checkOutDate))){
                IRoom room = reservation.getRoom();
                exRooms.remove(room);
            }
        }

        return exRooms;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        Set<Reservation> customerReservation = new HashSet<>();
        for(Reservation reservation : reservations){
            if(reservation.getCustomer().equals(customer)){
                customerReservation.add(reservation);
            }
        }
        return customerReservation;
    }

    public void printAllReservation(){
        for (Reservation reservation : reservations){
            System.out.println(reservation);
        }
    }


}
