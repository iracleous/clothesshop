/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.util;

import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.repository.ProductRepository;

/**
 *
 * @author iracl
 */
public class DataImport {
     private final CustomerRepository customerRepository ;
    private final ProductRepository productRepository ; 

    public DataImport(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    
    
    public void insertCustomers(){
        
        
           { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
        customerRepository.create(customer);
           }
        
         { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
       customerRepository.create(customer);
           }  
        { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
      customerRepository.create(customer);
           }  
         { Customer customer = new Customer();
        customer.setName("Sokratis");
        customer.setId(1);
        customer.setEmail("sokratis@mail.gr"); 
       customerRepository.create(customer);
           }
 
    }
    
    public void insertProducts(){ 
        {    Product product = new Product();
        product.setName("skirt 1");
        product.setPrice(1200);
        product.setProductCategory(ProductCategory.WOMEN);
        product.setPositionInShelf("A1");
        
        productRepository.create(product);
        }
        
         {    Product product = new Product();
        product.setName("skirt 2");
        product.setPrice(1200);
        product.setProductCategory(ProductCategory.WOMEN);
        product.setPositionInShelf("A1");
        
        productRepository.create(product);
        }
         {    Product product = new Product();
        product.setName("dress A");
        product.setPrice(1200);
        product.setProductCategory(ProductCategory.WOMEN);
        product.setPositionInShelf("A1");
        
        productRepository.create(product);
        }
          {    Product product = new Product();
        product.setName("dress B");
        product.setPrice(1200);
        product.setProductCategory(ProductCategory.WOMEN);
        product.setPositionInShelf("A1");
        
        productRepository.create(product);
        }
         
    }
 
}
