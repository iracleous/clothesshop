/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository.impl;

import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class ProductRepositoryImpl implements ProductRepository{

  private final List<Product> products;
  private int index;  

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
    }
    
     
    @Override
    public int create(Product product) {
            product.setId(index++);
            products.add(product);
            return product.getId();
    }

    @Override
    public Product read(int productId) {
        for (Product product:products){
            if (product.getId() == productId)
                return product;
        }
            return null;
    }

    @Override
    public List<Product> read() {
            return products;
    
    }

    @Override
    public void update(int productId, double price) {
        Product product =  read(productId);
        if(product !=null){
            product.setPrice(price);
        }
    }

    @Override
    public boolean delete(int productId) {
         Product product =  read(productId);
        if(product !=null){
            products.remove(product);
            return true;
        }
        return false;
        
     }
}
