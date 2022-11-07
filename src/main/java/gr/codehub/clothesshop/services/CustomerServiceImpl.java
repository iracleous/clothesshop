/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Order;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepositoryImpl;
import gr.codehub.clothesshop.repository.ProductRepository;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private ProductRepository productRepository = new ProductRepository(); 
    
    @Override
    public boolean register(Customer customer) {
        customerRepository.create(customer);
        return true;
    }

    @Override
    public boolean placeOrder(int customerId, int productId, int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public  Product[] searchProduct(String productName) {
            return productRepository.search(productName);
    }

    @Override
    public Order showOrderint(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printCustomers() {
       Customer [] customers= customerRepository.read();
       
       for (Customer customer:customers){
           System.out.println(customer);
       }
           
    }
    
}
