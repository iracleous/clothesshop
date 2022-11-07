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
public class ProductRepositoryImpl extends RepositoryImpl<Product>  implements ProductRepository{

     
    @Override
    public void update(int productId, double price) {
        Product product =  read(productId);
        if(product !=null){
            product.setPrice(price);
        }
    }

    @Override
    public List<Product> read(String productName) {
         List<Product> returnProducts =  new ArrayList<>();
          for (Product product:read()){
            if (product.getName()!=null && product.getName().contains(productName) )
                returnProducts.add(product) ;
        }
            return returnProducts;    
    }

}
