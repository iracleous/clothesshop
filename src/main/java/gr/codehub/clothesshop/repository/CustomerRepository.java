/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository;

import gr.codehub.clothesshop.model.Customer;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerRepository {
    //CRUD
    int create(Customer customer);
    Customer read(int customerId);
    List<Customer> read();
    void update(int customerId, String email);
    boolean delete(int customerId);
    
}
