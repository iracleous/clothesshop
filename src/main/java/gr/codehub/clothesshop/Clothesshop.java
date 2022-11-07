/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gr.codehub.clothesshop;

import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.CustomerRepositoryImpl;
import gr.codehub.clothesshop.repository.impl.ProductRepositoryImpl;
import gr.codehub.clothesshop.services.CustomerServiceImpl;
import java.util.List;
import gr.codehub.clothesshop.services.MarketService;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author iracl
 */
public class Clothesshop {

    public static void main(String[] args) {
   
        
        
        CustomerRepository custRepo = new CustomerRepositoryImpl();
        ProductRepository prodRepo = new ProductRepositoryImpl();
        
        MarketService customerService = new CustomerServiceImpl(custRepo,prodRepo);
        
        { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
        customerService.register(customer);}
        
         { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
        customerService.register(customer);}
         
        { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
        customerService.register(customer);}
        
         { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
        customerService.register(customer);}
        
      
         
         
        customerService.printCustomers();
        
        System.out.println("-----------------------------");
        
        Product product = new Product();
        product.setName("dress");
        product.setPrice(1200);
        product.setProductCategory(ProductCategory.WOMEN);
        product.setPositionInShelf("A1");
        
        customerService.addProduct(product);
        
        
        
        List<Product>  products = customerService.searchProduct("dress");
          
        for (Product productA:products){
       if (productA!=null)     System.out.println(productA.getId()+ " "+ productA.getName());
        }
    }
}
