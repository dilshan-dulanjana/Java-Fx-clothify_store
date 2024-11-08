package controller.supplier;

import dto.Product;
import dto.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.ServiceFactory;
import service.custom.SupplierServices;
import util.CrudUtil;
import util.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SupplierController implements SupplierService{

    SupplierServices services = ServiceFactory.getInstance().getServiceType(ServiceType.SUPPLIER);
    @Override
    public boolean addSupplier(Supplier supplier) {

        return services.addSupplier(supplier);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public Product searchSupplier(String id) {
        return null;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public ObservableList<Supplier> getAllSupplier() {

        return services.getAllSupplier();

    }

    public Integer setsuplierID() {
        String SQL = "SELECT sup_ID FROM supplier ORDER BY sup_ID DESC LIMIT 1";

        try {
            ResultSet resultSet = CrudUtil.execute(SQL);

            if (resultSet.next()) {  // Check if there is a result
                return resultSet.getInt(1);  // Retrieve the first column value in the result set
            } else {
                return null;  // Return null or handle this case as needed
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Supplier selectedSupplier(String name){
        ResultSet resultSet = null;
        try {
            resultSet = CrudUtil.execute("SELECT * FROM supplier WHERE name=?", name);
            if (resultSet.next()) {
                Integer supplierID = resultSet.getInt(1);
                String supname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String address = resultSet.getString(4);
                String telephone = resultSet.getString(5);


                Supplier supplier = new Supplier(supplierID, supname, email, address, telephone);
                System.out.println(supplier);
                return supplier;
            } else {
                System.out.println("supplier not found for name: " + name);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving product: " + e.getMessage(), e);
        }


    }

}
