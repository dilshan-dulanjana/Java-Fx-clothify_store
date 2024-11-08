package controller.oder;

import dto.CartItems;
import dto.Product;
import javafx.collections.ObservableList;

public interface PlaceOrderService {
    boolean addCartItems(CartItems cartItems);
    boolean updateCartItems(CartItems cartItems);
    CartItems searchCartItems(String id);
    boolean deleteCartItems(String id);
    ObservableList<CartItems > getAllCartItems();
}
