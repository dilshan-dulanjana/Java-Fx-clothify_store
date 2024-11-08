package controller.supplier;

import dto.Product;
import dto.Supplier;
import javafx.collections.ObservableList;

public interface SupplierService {
    boolean addSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);
    Product searchSupplier(String id);
    boolean deleteSupplier(String id);
    ObservableList<Supplier> getAllSupplier();
}
