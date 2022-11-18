/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author iracl
 */
import java.sql.*;

public class Db {

    public static final String H2_CONNECTION_STRING = "jdbc:h2:~/test";
    public static final String H2_USERNAME = "sa";
    public static final String H2_PASSWORD = "";

    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/eshop?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "123456";

    public static void main(String[] a) throws Exception {

        Class.forName(MYSQL_DRIVER);
        Connection conn = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);

        //creating database schema
        String createStatement = "create table product (id integer auto_increment primary key, name varchar(50));";

        Statement statement = conn.createStatement();
        statement.executeUpdate(createStatement);

        String data = "chocolate";

        String insertStatement = "insert into product (  name) values (?);";

        String columnNames[] = new String[]{"id"};

        PreparedStatement statement2 = conn.prepareStatement(insertStatement, columnNames);
        statement2.setString(1, data);

        if (statement2.executeUpdate() > 0) {
            ResultSet keys = statement2.getGeneratedKeys();
            while (keys.next()) {
                System.out.println("generated key = " + keys.getInt(1));
            }
        }

        String selectStatement = "select * from product ;";

        Statement statement3 = conn.createStatement();

        ResultSet rs = statement3.executeQuery(selectStatement);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "   " + rs.getString(2));
        }

        // add application code here
        conn.close();
    }
}
