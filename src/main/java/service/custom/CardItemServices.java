package service.custom;

import dto.CartItems;
import dto.Product;
import javafx.collections.ObservableList;

public interface CardItemServices {

    boolean addCartItem(CartItems cartItems);
    boolean updateCartItems(CartItems cartItems);
    Product searchCartItems(String id);
    boolean deleteCartItems(String id);
    ObservableList<Product> getAllCartItems();
}
