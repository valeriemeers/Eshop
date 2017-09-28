package be.vdab.dao.impl;

import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;
import be.vdab.entiteiten.OrderDetail;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    public List<Order> findOrdersForCustomer(Customer customer) {
        String SQL = "SELECT * FROM eshop.order WHERE customer_id = '" + customer.getId() + "'";
        return orderSQL(SQL);
    }

    public void saveOrder(Order order) {
        String SQL_ORDERINSERT = "INSERT INTO eshop.order (paymentMethod, total, date, customer_id, eshop_id) VALUES (?, ?, ?, ?, ?)";
        String SQL_ORDERDETAIL = "INSERT INTO orderdetail (amount, product_id, order_id) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ORDERINSERT, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement detailStatement = connection.prepareStatement(SQL_ORDERDETAIL)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, order.getPayMethod());
            statement.setDouble(2, order.getOrderTotal());
            statement.setDate(3, order.getDate());
            statement.setLong(4, order.getCustomerId());
            statement.setLong(5, order.geteShopId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long orderId = resultSet.getLong(1);

            System.out.println(statement);


            detailStatement.setDouble(1, order.getAmount());
            detailStatement.setLong(2, order.getProductId());
            detailStatement.setLong(3, orderId);        //orderId is pas in de vorige stap aangemaakt. Deze kan je met getGeneratedKeys() ophalen op het statement.
            System.out.println(detailStatement);
            detailStatement.executeUpdate();

            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Order> orderSQL(String SQL) {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
               // long id = rs.getLong(1);
                String paymentMethod = rs.getString(2);
                int total = rs.getInt(3);
                Date date = rs.getDate(4);
                //Long customerId = rs.getLong(5);
               // Long eShopId = rs.getLong(6);


                //List<OrderDetail> orderDetails = getOrderDetailsForOrderId(rs.getLong(1));

                 Order o = new Order();
                 o.setPayMethod(paymentMethod);
                 o.setOrderTotal(total);
                 o.setDate(date);

                orderList.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    private List<OrderDetail> getOrderDetailsForOrderId(long orderId) {
        List<OrderDetail> result = new ArrayList<>();
        String sql = "select * from orderdetail where order_id = " + orderId;

        try (Connection connection = ConnectionDao.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                double amount = resultSet.getDouble(2);
                long productId = resultSet.getLong(3);

                result.add(new OrderDetail(id, amount, productId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
