/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.maps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.ProductRepositoryImpl;
import gr.codehub.clothesshop.util.DataImport;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public class TestCatalog {
    public static void main(String[] args) {
        ProductRepository prodRepo = new ProductRepositoryImpl();
        DataImport dataImport = new DataImport(null, prodRepo);
        dataImport.insertProducts();
        
        Catalog catalog = new SetCatalogImpl();
        
        prodRepo
                .read()
                .stream()
                .forEach( product -> catalog.create(product.getName(), product));
                
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(catalog));  
        
        Optional<Product> optionalProduct = catalog.read("trousers1");
    //    System.out.println(""+ optionalProduct.get().getName());
        
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            System.out.println(""+product.getName()+" price= " +product.getPrice());
        }
        else{
            System.out.println("The product has not been found");
        }
            
            
        
        
    }
    
}
