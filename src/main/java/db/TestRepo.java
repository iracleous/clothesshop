/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.google.gson.GsonBuilder;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.DBProductRepositoryImpl;

/**
 *
 * @author iracl
 */
public class TestRepo {
    
    public static void main(String[] args) {
        
        ProductRepository productRepo = new DBProductRepositoryImpl();
        
        
        Product product = new Product();
        product.setName("New product");
        
        int newCode = productRepo.create(product);
        System.out.println("---------------------");
              
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(productRepo.read()));    
        
        
        
        System.out.println("---------------------");
         Product productDb = productRepo.read(newCode);
        System.out.println(productDb.getId() +   "   "+   productDb.getName() );
        
    }
    
}
