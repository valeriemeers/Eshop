package be.vdab.dao.impl;

import be.vdab.dao.ShopDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Eshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao{

    public List<Eshop> listAllShops() {
        String SQL = "select * from eshop";
        return EshopSQL(SQL);
    }

    private List<Eshop> EshopSQL(String SQL) {
        List<Eshop> eshopList;  //lokale variabele om geen 'state' bij te houden. Deze klasse is nu thread-safe(r).

        eshopList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {

                long id = rs.getInt(1);
                String info = rs.getString(2);
                String address = rs.getString(3);

                Eshop shop = new Eshop (id, info, address);
                eshopList.add(shop);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eshopList;
    }

}
