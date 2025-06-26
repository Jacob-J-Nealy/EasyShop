package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface CartDao
{
    ShoppingCart getByUserId(int userId);
    void add(int userId, ShoppingCartItem item);
    void update(int userId, int productId, int quantity);
    void delete(int userId);
}
