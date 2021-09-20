package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private static AdminResource instance;

    private AdminResource(){}

    public static AdminResource getInstance(){
        if(instance == null){
            instance = new AdminResource();
        }
        return instance;
    }

    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRoom(IRoom room){
            ReservationService.getInstance().addRoom(room);
    }

    public Collection<IRoom> getAllRooms(){
        return ReservationService.getInstance().getRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations(){
        ReservationService.getInstance().printAllReservation();
    }

}
