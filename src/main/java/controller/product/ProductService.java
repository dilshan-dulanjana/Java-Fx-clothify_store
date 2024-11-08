package controller.product;

import dto.Customer;
import dto.Product;
import javafx.collections.ObservableList;
import service.SuperService;

public interface ProductService  {

    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    Product searchProduct(String id);
    boolean deleteProduct(String id);
    ObservableList<Product> getAllProduct();
}
