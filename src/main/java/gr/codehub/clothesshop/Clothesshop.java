/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package gr.codehub.clothesshop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.codehub.clothesshop.exceptions.CustomerException;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.CustomerRepositoryImpl;
import gr.codehub.clothesshop.repository.impl.ProductRepositoryImpl;
import gr.codehub.clothesshop.services.CustomerServiceImpl;
import java.util.List;
import gr.codehub.clothesshop.services.MarketService;
import gr.codehub.clothesshop.util.DataImport;

/**
 *
 * @author iracl
 */
public class Clothesshop {

    public static void main(String[] args) {

        CustomerRepository custRepo = new CustomerRepositoryImpl();
        ProductRepository prodRepo = new ProductRepositoryImpl();

        MarketService customerService = new CustomerServiceImpl(custRepo, prodRepo);
        DataImport dataImport = new DataImport(custRepo, prodRepo);

        dataImport.insertCustomers();
        dataImport.insertProducts();

        try{
            Customer customer = new Customer();
            customerService.register(customer);
        }
        catch(CustomerException e){
            System.out.println("Customer exception " + e.getMessage());
        }
       
       /**/ 

        System.out.println("-----------------------------");

        List<Product> products = customerService.searchProduct("");
     //      System.out.println(new Gson().toJson(products));  
       
      System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(products));    
    }
}
