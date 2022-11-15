/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.util;

import gr.codehub.clothesshop.enums.CustomerCategory;
import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
import java.util.Date;

/**
 *
 * @author iracl
 */
public class DataImport {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    private final static String[] CUSTOMERS = {
        "1, Dimitris1, dimitris@gmail.com, 101.0, 2022-10-01, RETAIL",
        "2, Nick2, nick@gmail.com, 100.0, 2022-10-01, BUSINESS",
        "3, George3, george@gmail.com, 100.0, 2022-10-01, RETAIL",
        "4, Dimitris4, dimitris@gmail.com, 101.0, 2022-10-01, INTERNET",
        "5, Nick5, nick@gmail.com, 100.0, 2022-10-01, BUSINESS",
        "6, George6, george@gmail.com, 100.0, 2022-10-01, RETAIL",
        "7, Dimitris7, dimitris@gmail.com, 101.0, 2022-10-01, RETAIL",
        "8, Nick8, nick@gmail.com, 100.0, 2022-10-01, RETAIL",
        "9, George9, george@gmail.com, 100.0, 2022-10-01, BUSINESS",
        "10, Dimitris10, dimitris@gmail.com, 101.0, 2022-10-01, INTERNET",
        "11, Dimitris11, dimitris@gmail.com, 101.0, 2022-10-01, RETAIL",
        "12, Nick12, nick@gmail.com, 100.0, 2022-10-01, BUSINESS",
        "13, George13, george@gmail.com, 100.0, 2022-10-01, RETAIL",
        "14, Dimitris 14, dimitris@gmail.com, 101.0, 2022-10-01, RETAIL",
        "15, Nick 15, nick@gmail.com, 100.0, 2022-10-01, RETAIL",
        "16, George 16, george@gmail.com, 100.0, 2022-10-01, INTERNET",
        "17, Dimitris17, dimitris@gmail.com, 101.0, 2022-10-01, BUSINESS",
        "18, Nick18, nick@gmail.com, 100.0, 2022-10-01, BUSINESS",
        "19, George19, george@gmail.com, 100.0, 2022-10-01, RETAIL",
        "20, Dimitris20, dimitris@gmail.com, 101.0, 2022-10-01, RETAIL",};

    private final static String[] PRODUCTS = {
        "1, 180, suit, AAS, MEN, 20",
        "2, 50, shirt, ABS, MEN, 10",
        "3, 35, trousers, WAS, MEN, 20",
        "4, 350, dress, WAS, WOMEN, 50",
         "5, 180, trousers, AA1S, MEN, 20",
        "6, 50, tie, A2BS, MEN, 10",
        "7, 35, socks, W5AS, MEN, 20",
        "8, 350, soocks, W1AS, WOMEN, 50",
    
    
    };

    /**
     *
     * @param customerRepository
     * @param productRepository
     */
    public DataImport(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /**
     *
     */
    public void insertCustomers() {

        for (String customerString : CUSTOMERS) {
            try {
                String[] words = customerString.split(",");
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(words[0]));
                customer.setName(words[1].trim());
                customer.setEmail(words[2].trim());
                customer.setBalance(Double.parseDouble(words[3].trim()));
                String[] dateParts = words[4].trim().split("-");
                customer.setRegistrationDate(new Date(
                        Integer.parseInt(dateParts[0]) - 1900,
                        Integer.parseInt(dateParts[1]) - 1,
                        Integer.parseInt(dateParts[2])
                ));
                customer.setCustomerCategory(CustomerCategory.valueOf(words[5].trim()));
                customerRepository.create(customer);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     *
     */
    public void insertProducts() {

        for (String productString : PRODUCTS) {
            String[] words = productString.split(",");
            Product product = new Product();
            product.setId(Integer.parseInt(words[0]));
            product.setPrice(Double.parseDouble(words[1].trim()));
            product.setName(words[2].trim());
            product.setPositionInShelf(words[3].trim());
            product.setProductCategory(ProductCategory.valueOf(words[4].trim()));
            product.setStock(Integer.parseInt(words[5].trim()));
            productRepository.create(product);
        }
    }
}
