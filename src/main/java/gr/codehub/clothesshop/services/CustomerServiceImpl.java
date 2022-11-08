/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.exceptions.CustomerException;
import gr.codehub.clothesshop.exceptions.CustomerExceptionCodes;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Order;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
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

    @Override
    public void printCustomers() {
        List<Customer> customers = customerRepository.read();
        for (Customer customer : customers) {
            System.out.println(customer.getId() + "  " + customer.getName() + " " + customer.getRegistrationDate());
        }
    }

    @Override
    public void addProduct(Product product) {
        productRepository.create(product);
        return;
    }

}
