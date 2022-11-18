/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository.impl;

import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
import gr.codehub.clothesshop.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author iracl
 */
public class JpaProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager = JpaUtil.getEntityManager();

    @Override
    public void update(int productId, double price) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> read(String productName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int create(Product t) {

        /// insert product
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t.getId();
    }

    @Override
    public Product read(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> read() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
