package service;

import java.util.*;

import  model.Customer;

public class CustomerService {

    private static CustomerService instance;

    private Map<String, Customer> customers = new HashMap<>();

    private CustomerService(){}

    public static CustomerService getInstance(){
        if(instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(String email, String firstname, String lastname){
        try {
            if(customers.containsKey(email)){
                System.out.println("The account corresponding to this email already exists, please log in directly");
            }
            else {
                Customer customer = new Customer(firstname, lastname, email);
                customers.put(customer.getEmail(), customer);
                System.out.println("Created successfully, please log in");
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public Customer getCustomer(String customerEmail){
        if(customers.containsKey(customerEmail) == true){
            return customers.get(customerEmail);
        }
        else{
            System.out.println("Account does not exist");
            return null;
        }
    }

    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }
}
