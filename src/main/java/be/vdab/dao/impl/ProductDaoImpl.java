package be.vdab.dao.impl;

import be.vdab.dao.ProductDao;
import be.vdab.entiteiten.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    public List<Product> findProducts(String productname) {
        String SQL = "SELECT * FROM product WHERE name = '"+productname+"'";
        return productSQL(SQL);
    }

    private List<Product> productSQL(String SQL) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
        Statement statement = connection.createStatement()) {
           ResultSet rs = statement.executeQuery(SQL);

           while (rs.next()){

               long id = rs.getLong(1);
               String name = rs.getString(2);
               double price = rs.getDouble(3);
               int stock = rs.getInt(4);

               Product p = new Product(id, name, price, stock);
               productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
