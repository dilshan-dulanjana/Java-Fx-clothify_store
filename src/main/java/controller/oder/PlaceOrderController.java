package controller.oder;

import dto.CartItems;
import dto.Product;
import javafx.collections.ObservableList;

public class PlaceOrderController implements PlaceOrderService{
    @Override
    public boolean addCartItems(CartItems cartItems) {
        return false;
    }

    @Override
    public boolean updateCartItems(CartItems cartItems) {
        return false;
    }

    @Override
    public CartItems searchCartItems(String id) {
        return null;
    }

    @Override
    public boolean deleteCartItems(String id) {
        return false;
    }

    @Override
    public ObservableList<CartItems> getAllCartItems() {
        return null;
    }
}
