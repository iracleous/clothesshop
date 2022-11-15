/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.maps;

import gr.codehub.clothesshop.model.Product;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author iracl
 */
public class SetCatalogImpl implements Catalog<Product> {
    private HashSet<Product> products = new HashSet<>();
    

    @Override
    public void create(String key, Product t) {
        products.add(t);
        
     }

    @Override
    public Optional<Product> read(String key) {
       return     products
                   .stream()
                   .filter(product -> product.getName().equals(key))
                   .findFirst();
    }

    @Override
    public List<Product> read() {
        return products.stream().collect(Collectors.toList());    }

     @Override
    public boolean exists(String key) {
       Optional<Product> optProduct = read(key);
       return optProduct.isPresent();
      }
    
    @Override
    public boolean delete(String key) {
         Optional<Product> optProduct = read(key);
        if (optProduct.isPresent()){
            products.remove(optProduct.get());
            return true;
        }
        return false;
    }

   
    
}
