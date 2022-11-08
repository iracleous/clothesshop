/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.util;

import com.google.gson.Gson;
import gr.codehub.clothesshop.model.Customer;

/**
 *
 * @author iracl
 */
 


 
public class JsonPrint {
   public static void main(String args[])  {
 
       Customer customer = new Customer();
       customer.setName("Dimitris");
       
       
        System.out.println(new Gson().toJson(customer));    
       
       
   }
}