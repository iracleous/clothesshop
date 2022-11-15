/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.maps;

import gr.codehub.clothesshop.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author iracl
 */
public class CatalogImpl implements Catalog<Product> {
    
    private HashMap<String, Product> mapCatalog;
    
    public CatalogImpl(){
        mapCatalog = new HashMap<>();
    }

    @Override
    public void create(String key, Product t) {
        
       mapCatalog.put(key, t);
 
    }

    @Override
    public Optional<Product> read(String key) {
        Product product =  mapCatalog.get(key);
   //     if (product != null) return   Optional.of(product);
   //     return Optional.empty();
        
        return (product != null)? Optional.of(product) : Optional.empty();
    }

    @Override
    public List<Product> read() {
   //  return  mapCatalog.values().stream().collect(Collectors.toList());
        return new ArrayList( mapCatalog.values());
    }

    @Override
    public boolean delete(String key) {
        if (!exists(key)) return false;
        mapCatalog.remove(key);
         return true;   
    }

    @Override
    public boolean exists(String key) {
        return  mapCatalog.get(key) != null;
    }
    
    
    
}
