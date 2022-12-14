/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

import gr.codehub.clothesshop.enums.CustomerCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * This class models the customer. It has been created after the requirements A123/ 2022-07-04
 * @author iracl
 */

@Entity
public class Customer extends Person{
    
	private Date registrationDate;
        private double balance;
        private CustomerCategory customerCategory;
        
        
        @OneToMany(mappedBy = "customer")
        private List<Cart> carts;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }
        
        
        
    
}
