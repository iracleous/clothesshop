/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.clothesshop.repository.impl;

import static db.Db.CONNECTION_STRING;
import static db.Db.PASSWORD;
import static db.Db.USERNAME;
import gr.codehub.clothesshop.enums.ProductCategory;
import gr.codehub.clothesshop.model.Product;
import gr.codehub.clothesshop.repository.ProductRepository;
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
public class DBProductRepositoryImpl implements ProductRepository {

    
    private static final String CREATE_STATEMENT = "create table product (id integer identity primary key, "
            + "  name varchar(50),    price decimal(8,2), positionInShelf varchar(50), "
            + " ProductCategory varchar(50),   stock integer     );";
    private static final String INSERT_STATEMENT = "insert into product (  name, price,"
            + "positionInShelf,  ProductCategory, stock ) values (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_STATEMENT = "select * from product ;";
    private static final String SELECT_STATEMENT = "select * from product where id =?;";
        private static final String SELECT_BY_NAME_STATEMENT = "select * from product where name.contains(?);";
    private static final String DELETE_STATEMENT = "delete from product where id =?;";
 private static final String UPDATE_PRICE_STATEMENT = "update  product set price = ? where id =?;";
    
    
    
    @Override
    public int create(Product t) {
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            String columnNames[] = new String[]{"id"};
            PreparedStatement statement = conn.prepareStatement(INSERT_STATEMENT, columnNames);
            statement.setString(1, t.getName());
            statement.setDouble(2, t.getPrice());
            statement.setString(3, t.getPositionInShelf());
            statement.setString(4, t.getProductCategory().toString());
            statement.setInt(5, t.getStock());
             
            if (statement.executeUpdate() > 0) {
                ResultSet keys = statement.getGeneratedKeys();
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
                Product product = new Product();
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getDouble("Price"));
                product.setPositionInShelf(rs.getString("positionInShelf"));
                product.setProductCategory(
                        ProductCategory.valueOf(rs.getString("productCategory")));
                product.setStock(rs.getInt("Stock"));
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
               Product product = new Product();
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getDouble("Price"));
                product.setPositionInShelf(rs.getString("positionInShelf"));
                product.setProductCategory(
                        ProductCategory.valueOf(rs.getString("productCategory")));
                product.setStock(rs.getInt("Stock"));
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

    @Override
    public void update(int productId, double price) {
         try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_PRICE_STATEMENT);
            statement.setDouble(1, price);
            statement.setInt(2, productId);
            statement.executeUpdate();
        } catch (Exception e) {
         }
    }

    @Override
    public List<Product> read(String productName) {
     List<Product> products = new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(SELECT_BY_NAME_STATEMENT);
            statement.setString(1, productName );
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               Product product = new Product();
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getDouble("Price"));
                product.setPositionInShelf(rs.getString("positionInShelf"));
                product.setProductCategory(
                        ProductCategory.valueOf(rs.getString("productCategory")));
                product.setStock(rs.getInt("Stock"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            return products;
        }
    
    
    }
}
