package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;
import com.google.common.collect.Lists;

import java.util.List;

public class BasketDaoImpl implements BasketDao{
    List<Product> basket = Lists.newArrayList();

    public void saveOrUpdateBasket(Basket basket) {

    }

    public void addProductToBasket(Product product) {
        basket.add(product);
    }

    public void removeProductFromBasket(Product product) {
        basket.remove(product);

    }

    public Basket getBasket() {
        return null;
    }

    public void clearBasket() {

    }
}
