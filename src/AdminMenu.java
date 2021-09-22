import api.AdminResource;
import model.IRoom;
import model.Room;
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

    public static void startActions(){
        printAdminMenu();
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
        while( action != 6){
            switch (action){
                case 1:
                    System.out.println(AdminResource.getInstance().getAllCustomers());
                    printAdminMenu();
                    break;
                case 2:
                    System.out.println(AdminResource.getInstance().getAllRooms());
                    printAdminMenu();
                    break;
                case 3:
                    AdminResource.getInstance().displayAllReservations();
                    break;
                case 4:
                    String flag;
                    do {
                        System.out.println("Enter room number");
                        String roomNumber = sc.next();
                        System.out.println("Enter price per night");
                        double price = sc.nextDouble();
                        System.out.println("Enter room type: 1 for single bed, 2 for double bed");
                        int type = sc.nextInt();
                        while (type != 1 && type != 2) {
                            System.out.println("Please input 1 & 2");
                            type = sc.nextInt();
                        }
                        RoomType roomType;
                        if (type == 1) {
                            roomType = RoomType.SINGLE;
                        } else {
                            roomType = RoomType.DOUBLE;
                        }
                        IRoom room = new Room(roomNumber, price, roomType);
                        AdminResource.getInstance().addRoom(room);
                        System.out.println("Would you add another room? Enter y or n");
                        flag = sc.next();
                        flag = YesOrNo(flag);
                    }while(flag.equals("y"));
                    printAdminMenu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("invalid input");
                    printAdminMenu();
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

    public static String YesOrNo(String flag){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while(flag.equals("y")&& flag.equals("n")) {
            System.out.println("Please input y or n");
            flag = sc.next();
            if(n == 10){
                break;
            }
            n++;
        }
        if(n == 10){
            System.out.println("default n");
            flag = "n";
        }
        return flag;
    }

}
