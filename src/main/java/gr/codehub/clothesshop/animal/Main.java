/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.animal;

/**
 *
 * @author iracl
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(  animal.getClass().getName());
        
        if (animal instanceof Dog){
            System.out.println("The animal is a Dog");
        }
        
       if (animal instanceof Animal){
            System.out.println("The animal is an animal");
        }
          
      if (animal instanceof Object){
            System.out.println("The animal is an object");
        }
        
        if (animal instanceof Cat){
            System.out.println("The animal is a cat");
        } 
        
    }
}
