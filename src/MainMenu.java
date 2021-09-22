import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation Application");
        printMainMenu();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.length();
        int action;
        if(str.length() > 1){
            action = 0;
        }
        else {
            action = str.charAt(0) - '0';
        }
        while (5 != action) {
            switch (action) {
                case 1:
                    System.out.println("Enter CheckIn Date mm/dd/yyyy like 03/27/2021");
                    String checkInString = sc.next();
                    LocalDate checkInDate = getDateFromString(checkInString);
                    System.out.println("Enter CheckOut Date mm/dd/yyyy like 16/9/2021");
                    String checkOutString = sc.next();
                    LocalDate checkOutDate = getDateFromString(checkOutString);
                    System.out.println(HotelResource.getInstance().findARoom(checkInDate, checkOutDate));

                    System.out.println("--------------");
                    System.out.println("Would you like to book a room? y/n");
                    if(AdminMenu.YesOrNo(sc.next()).equals("y")){
                        System.out.println("Do you have a account with us? y/n");
                        if(AdminMenu.YesOrNo(sc.next()).equals("n")){
                            System.out.println("Please sign up");
                        }
                        else if(AdminMenu.YesOrNo(sc.next()).equals("y")){
                            System.out.println("Enter Email format: name@domain.com");
                            String email1 = sc.next();
                            if(HotelResource.getInstance().getCustomer(email1) != null){
                                System.out.println("What room number would you like to reserve?");
                                String roomNumber =sc.next();
                                IRoom room = HotelResource.getInstance().getIRoom(roomNumber);
                                if(room != null){
                                    System.out.println(HotelResource.getInstance().bookARoom(email1,room,checkInDate,checkOutDate));
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("Enter Email format: name@domain.com");
                    String email2 = sc.next();
                    Customer customer = HotelResource.getInstance().getCustomer(email2);
                    if( customer != null) {
                        System.out.println(HotelResource.getInstance().getCustomerReservations(customer));
                    }
                    break;
                case 3:
                    System.out.println("Enter Email format: name@domain.com");
                    String email3 = sc.next();
                    System.out.println("First name");
                    String firstname = sc.next();
                    System.out.println("Last name");
                    String lastname = sc.next();
                    HotelResource.getInstance().createACustomer(email3, firstname, lastname);
                    printMainMenu();
                    break;
                case 4:
                    AdminMenu.startActions();
                    printMainMenu();
                    break;
                default:
                    System.out.println("invalid input");
                    printMainMenu();
                    break;
            }
            str = sc.next();
            length = str.length();
            if(str.length() > 1){
                action = 0;
            }
            action = str.charAt(0) - '0';
        }
    }


    public static void printMainMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an Account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("---------------------------------------------");
        System.out.println("Please select a number for the menu option");
    }

    public static LocalDate getDateFromString(String str){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDate date = LocalDate.parse(str,dtf);
        return date;
    }
}
