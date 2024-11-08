package controller.product;

import dto.Customer;
import dto.Product;
import javafx.collections.ObservableList;
import service.ServiceFactory;
import service.custom.ProductServices;
import util.CrudUtil;
import util.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProductController implements ProductService {

    ProductServices services = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);
    public boolean addProduct(Product product){


       return services.addProduct(product);

    }

    @Override
    public boolean updateProduct(Product product) {


      return   services.updateProduct(product);

    }

    @Override
    public Product searchProduct(String id) {


      return   services.searchProduct(id);
    }


    @Override
    public boolean deleteProduct(String id) {

        return services.deleteProduct(id);

    }

    @Override
    public ObservableList<Product> getAllProduct() {
        return null;
    }

}
