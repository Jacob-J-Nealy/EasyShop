package org.yearup.data.mysql;

import org.yearup.data.CartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;

public class MySqlCartDao extends MySqlDaoBase implements CartDao {

    public MySqlCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {

    }

    @Override
    public void add(int userId, ShoppingCartItem item) {

    }

    @Override
    public void update(int userId, int productId, int quantity) {

    }

    @Override
    public void delete(int userId) {

    }
}
