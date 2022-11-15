/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.maps;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public interface Catalog<T> {
  
    //CRUD
    void create(String key, T t);
    Optional<T> read(String key);
    List<T> read();
    boolean delete(String key);
    boolean exists(String key);
    
}
