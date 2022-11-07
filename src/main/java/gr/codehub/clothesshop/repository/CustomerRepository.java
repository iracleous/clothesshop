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
public interface CustomerRepository extends Repository<Customer>{
     
    void update(int customerId, String email);
    
   void updateAll (int customerId,  Customer newData); 
    
}
