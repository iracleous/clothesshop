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
public class DBCustomerRepositoryImpl implements CustomerRepository{

    
    
    
    
    
    @Override
    public void update(int customerId, String email) {
     }

    @Override
    public void updateAll(int customerId, Customer newData) {
     }

    @Override
    public int create(Customer t) {
 return 1;
    }

    @Override
    public Customer read(int id) {
 return null;
    }

    @Override
    public List<Customer> read() {
        return new ArrayList<>();
    }

    @Override
    public boolean delete(int id) {
         return false;
    }
    
    
    
    
    
}
