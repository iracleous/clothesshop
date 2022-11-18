/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author iracl
 */
@Entity
public class OrderItem extends PersistentClass {
    
      private int quantity;
    private double discountPerUnit;  
    
    @ManyToOne
    private Product product;

    
    @ManyToOne
    private Cart cart;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscountPerUnit() {
        return discountPerUnit;
    }

    public void setDiscountPerUnit(double discountPerUnit) {
        this.discountPerUnit = discountPerUnit;
    }

    public Cart getOrder() {
        return cart;
    }

    public void setOrder(Cart order) {
        this.cart = order;
    }
    
    
}
