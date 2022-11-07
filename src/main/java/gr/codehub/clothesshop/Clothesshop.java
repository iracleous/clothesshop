/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gr.codehub.clothesshop;

import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.CustomerRepositoryImpl;
import gr.codehub.clothesshop.repository.impl.ProductRepositoryImpl;
import gr.codehub.clothesshop.services.CustomerService;
import gr.codehub.clothesshop.services.CustomerServiceImpl;
import java.util.List;

/**
 *
 * @author iracl
 */
public class Clothesshop {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr");
        
        
        CustomerRepository custRepo = new CustomerRepositoryImpl();
        ProductRepository prodRepo = new ProductRepositoryImpl();
        
        CustomerService customerService = new CustomerServiceImpl(custRepo,prodRepo);
        customerService.register(customer);
        customerService.register(customer);
        customerService.register(customer);
        customerService.register(customer);
        
        
        customerService.printCustomers();
        System.out.println("-----------------------------");
        List<Product>  products = customerService.searchProduct("dress");
        
        for (Product product:products){
       if (product!=null)     System.out.println(product.getId()+ " "+ product.getName());
        }
    }
}
