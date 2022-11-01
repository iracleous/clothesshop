/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

/**
 *
 * @author iracl
 */
public class OrderItem extends PersistentClass {
    private Product product;
    private int quantity;
    private double discountPerUnit;
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
}
