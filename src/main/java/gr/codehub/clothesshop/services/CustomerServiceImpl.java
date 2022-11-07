/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Order;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.impl.CustomerRepositoryImpl;
import gr.codehub.clothesshop.repository.ProductRepository;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository ;
    private final ProductRepository productRepository ; 

    public CustomerServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
   
    
    
    
    
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
    public  List<Product>  searchProduct(String productName) {
            return productRepository.read();
    }

    @Override
    public Order showOrderint(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printCustomers() {
       List<Customer>   customers= customerRepository.read();
       
       for (Customer customer:customers){
           System.out.println(customer);
       }
           
    }
    
}
