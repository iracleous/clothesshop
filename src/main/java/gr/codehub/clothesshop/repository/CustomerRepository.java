/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository;

import gr.codehub.clothesshop.model.Customer;

/**
 *
 * @author iracl
 */
public class CustomerRepository {
    private Customer[] customers = new Customer[20];
    private int position = 0;
    //CRUD should be implemented
    
    public void insertCustomer(Customer customer){
        if (position<20){
        customers[position++] = customer ;
        }
    }
    
    public void printCustomers(){
        for (int i=0;i<position; i++){
            System.out.println(customers[i].getName() + " "+ customers[i].getEmail());
        }
           
    }
}
