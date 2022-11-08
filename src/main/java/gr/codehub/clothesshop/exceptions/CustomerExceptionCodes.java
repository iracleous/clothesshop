/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.exceptions;

/**
 *
 * @author iracl
 */
public class CustomerExceptionCodes {
    public final static String CUSTOMER_IS_NULL = "The customer is null";
    public final static String CUSTOMER_NOT_FOUND = "The customer was not found";
    public final static String CUSTOMER_ALREADY_EXISTS = "The customer already exists";
    public final static String CUSTOMER_INVALID_DATA = "The given data are not appropriate to create a customer";
    public final static String CUSTOMER_MISSING_DATA = "Not all data are given to create a customer";
    public final static String CUSTOMER_OVER_DRAFT = "The customer has exceeded the balance limit";
    public final static String CUSTOMER_OUT_OF_RANGE = "The customer's address cannot be supported";
}
