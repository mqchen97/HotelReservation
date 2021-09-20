package model;

public class Tester {
    public static void main(String[] args) {
        try{
            Customer customer = new Customer("First", "Second", "J@email.com");
            System.out.println(customer);
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getLocalizedMessage());
        }

    }
}
