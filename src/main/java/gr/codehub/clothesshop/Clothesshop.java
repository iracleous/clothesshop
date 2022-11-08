/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package gr.codehub.clothesshop;

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

        customerService.printCustomers();

        System.out.println("-----------------------------");

        List<Product> products = customerService.searchProduct("dress");

        for (Product productA : products) {
            if (productA != null) {
                System.out.println(productA.getId() + " " + productA.getName());
            }
        }
    }
}
