package be.vdab.dao.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopDaoImplTest {
    @Test
    public void test_listAllShops() throws Exception {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        assertThat(shopDao.listAllShops()).hasSize(1);
    }

}