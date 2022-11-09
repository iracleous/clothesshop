/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services;

import gr.codehub.clothesshop.exceptions.CustomerException;

/**
 *
 * @author iracl
 */
public interface  IoServices {
    
    /**
     *
     * @param filename
     * @throws CustomerException
     */
    void saveCustomerToCsv(String filename) throws CustomerException;
    
    /**
     *
     * @param filename
     * @return returns the number of the read rows 
     * @throws CustomerException
     */
    int readCustomerFromCsv(String filename) throws CustomerException;
    
}
