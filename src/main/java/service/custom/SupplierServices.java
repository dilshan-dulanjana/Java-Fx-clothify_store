package service.custom;

import dto.Product;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface SupplierServices extends SuperService {
    boolean addSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);
    Product searchSupplier(Supplier supplier);
    boolean deleteSupplier(String id);
    ObservableList<Supplier> getAllSupplier();


}
