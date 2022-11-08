/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.exceptions.ProductException;
import gr.codehub.clothesshop.exceptions.CustomerException;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Order;
import gr.codehub.clothesshop.model.Product;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface MarketService {
    
    void register(Customer customer) throws CustomerException;
    
    void addProduct(Product product) throws ProductException;
    
    List<Product>  searchProduct(String productName);
    boolean placeOrder(int customerId, int productId, int orderId);
    Order showOrderint (int orderId);   

    
    void printCustomers();
}
