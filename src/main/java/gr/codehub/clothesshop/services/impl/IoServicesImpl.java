/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.services.impl;

import gr.codehub.clothesshop.enums.CustomerCategory;
import gr.codehub.clothesshop.exceptions.CustomerException;
import gr.codehub.clothesshop.exceptions.CustomerExceptionCodes;
import gr.codehub.clothesshop.model.Customer;
import gr.codehub.clothesshop.repository.CustomerRepository;
import gr.codehub.clothesshop.services.IoServices;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iracl
 */
public class IoServicesImpl implements IoServices {

    private CustomerRepository customerRepository;

    public IoServicesImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomerToCsv(String filename) throws CustomerException {
        File file = new File(filename);

        List<Customer> customers = customerRepository.read();
        try ( PrintWriter pw = new PrintWriter(file)) {
            pw.println("id,name,address,email,tel,registrationDate,balance,customerCategory");
            for (Customer customer : customers) {
                pw.println(
                        customer.getId()
                        + "," + customer.getName()
                        + "," + customer.getAddress()
                        + "," + customer.getEmail()
                        + "," + customer.getTel()
                        + "," + (customer.getRegistrationDate().getYear() + 1900) + "-"
                        + (customer.getRegistrationDate().getMonth() + 1) + "-"
                        + customer.getRegistrationDate().getDay()
                        + "," + customer.getBalance()
                        + "," + customer.getCustomerCategory());
            }
        } catch (FileNotFoundException ex) {
            throw new CustomerException(CustomerExceptionCodes.CUSTOMER_FILE_NOT_FOUND);
        }
    }

    @Override
    public int readCustomerFromCsv(String filename) throws CustomerException {

        File file = new File(filename);
        int rowsRead=0;
        try {
            Scanner scanner = new Scanner(file);

            scanner.nextLine();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try{
                    String[] words = line.split(",");
                    Customer customer = new Customer();
                    customer.setId(Integer.parseInt(words[0]));
                    customer.setName(words[1].trim());
                    customer.setAddress(words[2].trim());
                    customer.setEmail(words[3].trim());
                    customer.setTel(words[4].trim());
                    customer.setBalance(Double.parseDouble(words[6].trim()));
                    customer.setCustomerCategory(CustomerCategory.valueOf(words[7]));
                    String[] dateParts = words[5].trim().split("-");
                    customer.setRegistrationDate(new Date(
                            Integer.parseInt(dateParts[0]) - 1900,
                            Integer.parseInt(dateParts[1]) - 1,
                            Integer.parseInt(dateParts[2])
                    ));
                    customerRepository.create(customer);
                    rowsRead++;
                }
                catch(Exception e)
                {
                    System.out.println("This row has been dropped");
                }
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(IoServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsRead;

    }
}
