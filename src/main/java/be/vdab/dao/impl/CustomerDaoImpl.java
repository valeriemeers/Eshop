package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findCustomers(String name, String firstname, String username) {
        String SQL = "select * from customer where name = '"+name+"' and fName = '"+firstname+"' and username = '"+username+"'";
        return customerSQL(SQL).get(0);
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {
        String SQL = "SELECT * FROM customer WHERE username = '"+username+"' AND password = '"+password+"'";
        return customerSQL(SQL).get(0);
    }



    private List<Customer> customerSQL(String SQL) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {

                long id = rs.getInt(1);
                String name = rs.getString(2);
                String firstName = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String username = rs.getString(6);
                String password = rs.getString(7);

                Customer c = new Customer(id, username, password, name, firstName, email, address);
                customerList.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
