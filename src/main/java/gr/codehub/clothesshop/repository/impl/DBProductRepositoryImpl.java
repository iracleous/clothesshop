/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository.impl;

import static db.Db.CONNECTION_STRING;
import static db.Db.PASSWORD;
import static db.Db.USERNAME;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class DBProductRepositoryImpl implements Repository<Product> {

    private static final String CREATE_STATEMENT = "create table product (id integer identity primary key, name varchar(50));";
    private static final String INSERT_STATEMENT = "insert into product (  name) values (?);";
    private static final String SELECT_ALL_STATEMENT = "select * from product ;";
    private static final String SELECT_STATEMENT = "select * from product where id =?;";
    private static final String DELETE_STATEMENT = "delete* from product where id =?;";

    @Override
    public int create(Product t) {
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            String columnNames[] = new String[]{"id"};
            PreparedStatement statement2 = conn.prepareStatement(INSERT_STATEMENT, columnNames);
            statement2.setString(1, t.getName());
            if (statement2.executeUpdate() > 0) {
                ResultSet keys = statement2.getGeneratedKeys();
                while (keys.next()) {
                    return keys.getInt(1);
                }
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Product read(int productId) {
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(SELECT_STATEMENT);
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                return product;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Product> read() {
        List<Product> products = new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            return products;
        }
    }

    @Override
    public boolean delete(int id) {
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(DELETE_STATEMENT);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
