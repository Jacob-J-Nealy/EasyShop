package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);

    // Added These Methods for Shopping Cart
    void add(int userId, ShoppingCartItem item);
    void update(int userId, int productId, int quantity);
    void delete(int userId);
}
