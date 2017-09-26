package be.vdab.dao.impl;

import be.vdab.dao.ShopDao;
import be.vdab.entiteiten.Eshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl extends BaseDao implements ShopDao{

    public List<Eshop> listAllShops() {
        String SELECT_ALL_SHOPS = "select * from eshop";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_SHOPS);
            List<Eshop> listShops = new ArrayList<>();
            while (resultSet.next()){
                listShops.add(new Eshop(resultSet.getInt("id"), resultSet.getString("info"), resultSet.getString("address")));
            }
            return listShops;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
