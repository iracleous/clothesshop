/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.model;

import gr.codehub.clothesshop.enums.ProductCategory;

/**
 *
 * @author iracl
 */
public class Product extends PersistentClass{
    private String name;
    private double price;
    private String positionInShelf;
    private ProductCategory productCategory;
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPositionInShelf() {
        return positionInShelf;
    }

    public void setPositionInShelf(String positionInShelf) {
        this.positionInShelf = positionInShelf;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
    
}
