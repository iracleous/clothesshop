/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository.impl;

import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerRepositoryImpl implements CustomerRepository {
  private final List<Customer> customers;
  private int index;  

    public CustomerRepositoryImpl() {
        this.customers = new ArrayList<>();
    }
    
     
    @Override
    public int create(Customer customer) {
            customer.setId(index++);
            customers.add(customer);
            return customer.getId();
    }

    @Override
    public Customer read(int customerId) {
        for (Customer customer:customers){
            if (customer.getId() == customerId)
                return customer;
        }
            return null;
    }

    @Override
    public List<Customer> read() {
            return customers;
    
    }

    @Override
    public void update(int customerId, String email) {
        Customer customer =  read(customerId);
        if(customer !=null){
            customer.setEmail(email);
        }
    }

    @Override
    public boolean delete(int customerId) {
         Customer customer =  read(customerId);
        if(customer !=null){
            customers.remove(customer);
            return true;
        }
        return false;
        
     }
}
