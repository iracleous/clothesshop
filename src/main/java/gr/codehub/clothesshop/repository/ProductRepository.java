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
public interface  ProductRepository extends Repository<Product>{
   
    void update(int productId, double price);
    List<Product> read(String productName);
}
