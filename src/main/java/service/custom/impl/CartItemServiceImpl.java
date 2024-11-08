package service.custom.impl;

import dto.CartItems;
import dto.Product;
import javafx.collections.ObservableList;
import service.custom.CardItemServices;

public class CartItemServiceImpl implements CardItemServices {
    @Override
    public boolean addCartItem(CartItems cartItems) {
        return false;
    }

    @Override
    public boolean updateCartItems(CartItems cartItems) {
        return false;
    }

    @Override
    public Product searchCartItems(String id) {
        return null;
    }

    @Override
    public boolean deleteCartItems(String id) {
        return false;
    }

    @Override
    public ObservableList<Product> getAllCartItems() {
        return null;
    }
}
