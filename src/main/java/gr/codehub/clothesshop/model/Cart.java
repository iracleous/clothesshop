/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 *
 * @author iracl
 */
@Entity
public class Cart extends PersistentClass{
    private Date purchaseDateTime;
    private String paymentType;
  
    @ManyToOne
    private Customer customer;
    
    @OneToMany(mappedBy = "cart")
    private List<OrderItem> list;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    public Date getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(Date purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
}
