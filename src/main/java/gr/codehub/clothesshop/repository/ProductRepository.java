/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository;

import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Product;
import java.util.ArrayList;

/**
 *
 * @author iracl
 */
public final class ProductRepository {
    private Product[] products = new Product[20];
    private int position;
    
    public ProductRepository(){
        Product product = new Product(
        5, "suit", 100, "A1", ProductCategory.MEN, 3     
        );
        insertProduct(product);
        
        Product product2 = new Product(
        6, "dress", 200, "A1", ProductCategory.WOMEN, 3     
        );
        insertProduct(product2);
    }
    
    
    //create
     public void insertProduct(Product product){
         products[position++] = product;     }       
    //read
     
     public Product[] search(String productName){
         Product[] foundProducts  = new  Product[10];
         int numberFoundProducts = 0;
         for (int i = 0; i< products.length; i++){
           if( products[i]!=null &&   products[i].getName().equals(productName))  foundProducts[numberFoundProducts++] = products[i];
         }
         return foundProducts;
     }
    //update
    //delete
    
}
