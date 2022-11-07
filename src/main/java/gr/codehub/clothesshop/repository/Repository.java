/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository;

 
import gr.codehub.clothesshop.model.PersistentClass;
import java.util.List;

/**
 *
 * @author iracl
 * @param <T>
 */
public interface Repository<T extends PersistentClass> {
    
    //CRUD
    int create(T t);
    T read(int id);
    List<T> read();
  
    boolean delete(int id);

}
