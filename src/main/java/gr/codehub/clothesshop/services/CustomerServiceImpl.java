/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.dtos.StatisticalDtoBalalances;
import gr.codehub.clothesshop.exceptions.CustomerException;
import gr.codehub.clothesshop.exceptions.CustomerExceptionCodes;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Order;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements MarketService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /**
     *
     * @param customer
     * @throws CustomerException
     */
    @Override
    public void register(Customer customer) throws CustomerException {
        if (customer == null) {
            throw new CustomerException(CustomerExceptionCodes.CUSTOMER_IS_NULL);
        }
        if (customer.getEmail() == null) {
            throw new CustomerException(CustomerExceptionCodes.CUSTOMER_MISSING_DATA);
        }
        if (customer.getEmail().contains("gmail")) {
            throw new CustomerException(CustomerExceptionCodes.CUSTOMER_INVALID_DATA);
        }
        customerRepository.create(customer);
    }

    @Override
    public boolean placeOrder(int customerId, int productId, int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> searchProduct(String productName) {
        return productRepository.read(productName);
    }

    @Override
    public Order showOrderint(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Implementation of paging
     * @param pageCount  which page of data to return
     * @param pageSize   number of items per page
     * @return list of items within the requested page
     */
    @Override
    public List<Customer> findCustomers(int pageCount, int pageSize){
        List<Customer> customers = customerRepository.read();
        List<Customer> returnCustomers = new ArrayList<>();
        int counter = -1;
        for (Customer customer : customers) { 
            counter++;
           if (counter> (pageCount-1)*pageSize-1 && counter <  (pageCount)*pageSize)
               returnCustomers.add(customer);
        }
        return returnCustomers;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.create(product);
        return;
    }

    @Override
    public List<StatisticalDtoBalalances> calculateTotalBalancesPerCategory() {
       List<StatisticalDtoBalalances> statisticsList = new ArrayList<>();
        
       
       
       
       return statisticsList;
    }

}
