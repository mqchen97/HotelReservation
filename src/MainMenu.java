import api.HotelResource;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation Application");
        printMainMenu();
        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();

        while (5 != action) {
            switch (action) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Enter Email format: name@domain.com");
                    String email = sc.next();
                    System.out.println("First name");
                    String firstname = sc.next();
                    System.out.println("Last name");
                    String lastname = sc.next();
                    HotelResource.getInstance().createACustomer(email, firstname, lastname);
                    printMainMenu();
                    break;
                case 4:

                    break;
                default:
                    printMainMenu();
            }

            action = sc.nextInt();
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
}
