package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource instance;
    private HotelResource(){}
    public static HotelResource getInstance(){
        if(instance == null){
            instance = new HotelResource();
        }
        return instance;
    }

    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void createACustomer(String email, String firstname, String lastname){
        CustomerService.getInstance().addCustomer(email,firstname,lastname);
    }

    public IRoom getIRoom(String roomNumber){
        for(IRoom room : ReservationService.getInstance().getRooms()){
            if(room.getRoomNumber().equals(roomNumber)){
                return room;
            }
        }
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate){
        Customer customer = HotelResource.getInstance().getCustomer(customerEmail);
        return ReservationService.getInstance().reserveARoom(customer,room,checkInDate,checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(Customer customer){
        return ReservationService.getInstance().getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(LocalDate checkIn, LocalDate checkOut){
        return ReservationService.getInstance().findRooms(checkIn,checkOut);
    }

}
