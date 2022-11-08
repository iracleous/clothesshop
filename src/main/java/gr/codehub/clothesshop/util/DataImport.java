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
        "1, Dimitris, dimitris@gmail.com, kk, 2022-10-01, RETAIL",
        "2, Nick, nick@gmail.com, 100.0, 2022-10-01, RETAIL",
        "3, George, george@gmail.com, 100.0, 2022-10-01, RETAIL"
    };
    
    private final static String[] PRODUCTS = {
        "1, 180, suit, AAS, MEN, 20",
        "2, 50, shirt, ABS, MEN, 10",
        "3, 35, trousers, WAS, MEN, 20",
        "4, 350, dress, WAS, WOMEN, 50",};
    
    public DataImport(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    
    public void insertCustomers() {
        
        for (String customerString : CUSTOMERS) {
          try{  
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
          }
          catch(Exception e)
          {
              System.out.println(e.getMessage());
          }
            
        }
    }
    
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
