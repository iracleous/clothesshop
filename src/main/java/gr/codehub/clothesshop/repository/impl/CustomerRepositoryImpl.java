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
public class CustomerRepositoryImpl extends RepositoryImpl<Customer>
       implements CustomerRepository {
       
    @Override
    public void update(int customerId, String email) {
        Customer customer =  read(customerId);
        if(customer !=null){
            customer.setEmail(email);
        }
    }
     
}
