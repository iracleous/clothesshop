/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

import gr.codehub.clothesshop.enums.CustomerCategory;
import java.util.Date;

/**
 * This class models the customer. It has been created after the requirements A123/ 2022-07-04
 * @author iracl
 */
public class Customer extends Person{
    
	private Date registrationDate;
        private double balance;
        private CustomerCategory customerCategory;

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
