import model.RoomType;

import java.util.Scanner;

public class AdminMenu {
    public static void printAdminMenu(){
        System.out.println("Admin Menu");
        System.out.println("---------------------------------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Add Test Data");
        System.out.println("6. Back to Main Menu");
        System.out.println("---------------------------------------------");
        System.out.println("Please select a number for the menu option");
    }

    public void startActions(){
        printAdminMenu();
        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();
        while( action != 6){
            switch (action){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Enter room number");
                    String roomNumber = sc.next();
                    System.out.println("Enter price per night");
                    double price = sc.nextDouble();
                    System.out.println("Enter room type: 1 for single bed, 2 for double bed");
                    int type = sc.nextInt();
                    if(type == 1){
                        RoomType roomType = SINGLE;
                    }
                    break;
                case 5:
                    break;
            }
            action = sc.nextInt();
        }
    }
}
