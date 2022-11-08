/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.dtos.StatisticalDtoBalalances;
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

    /**
     *
     * @param customer
     * @throws CustomerException
     */
    void register(Customer customer) throws CustomerException;

    /**
     *
     * @param product
     * @throws ProductException
     */
    void addProduct(Product product) throws ProductException;

    /**
     *
     * @param productName
     * @return
     */
    List<Product>  searchProduct(String productName);

    /**
     *
     * @param customerId
     * @param productId
     * @param orderId
     * @return
     */
    boolean placeOrder(int customerId, int productId, int orderId);

    /**
     *
     * @param orderId
     * @return
     */
    Order showOrderint (int orderId);   

    /**
     *
     * @param pageCount
     * @param pageSize
     * @return
     */
    List<Customer> findCustomers(int pageCount, int pageSize);

    /**
     * Calculates the sum of balances per customer category 
     * Ticket No. R12
     * @return
     */
    List<StatisticalDtoBalalances> calculateTotalBalancesPerCategory();
}
