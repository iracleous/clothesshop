/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import com.google.gson.GsonBuilder;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.repository.impl.JpaProductRepositoryImpl;
import gr.codehub.clothesshop.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author iracl
 */
public class TestJpa {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Product product = new Product();

        product.setName("Dress");

        /// insert product
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        Customer customer = new Customer();
        customer.setName("Nikos");
        customer.setAddress("Lamia");

        /// insert Customer
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        System.out.println(customer.getId());

        //find Customer 
        Customer customerDb = entityManager.find(Customer.class, 1);
        System.out.println("" + customerDb.getName() + " id = " + customerDb.getId());

        /////////////////////
        ProductRepository proRepo = new JpaProductRepositoryImpl();
        List<Product> products = proRepo.read();

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(products));

    }

}
