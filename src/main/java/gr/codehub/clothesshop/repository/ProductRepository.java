/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository;

import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface  ProductRepository {
      //CRUD
    int create(Product product);
    Product read(int productId);
    List<Product> read();
    void update(int productId, double price);
    boolean delete(int productId);
    
    
}
