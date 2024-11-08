package repository.custom.impl;

import dto.Product;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.custom.SupplierDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplier) {
        System.out.println("Repository  :"+supplier);
        String SQL ="INSERT INTO supplier VALUES(?,?,?,?,?)";

        try {
            return CrudUtil.execute(
                    SQL,
                    supplier.getID(),
                    supplier.getName(),
                    supplier.getEmail(),
                    supplier.getAddress(),
                    supplier.getTelephone()

            );
        } catch (SQLException e) {
            System.out.println("Repository Error :"+e);
            return false;
        }

    }

    @Override
    public boolean update(SupplierEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Product search(String s) {
        return null;
    }

    @Override
    public ObservableList<Supplier> findAll() {
        ObservableList<Supplier> supplierObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM supplier";

        try {
            ResultSet resultSet = CrudUtil.execute(SQL);

            while (resultSet.next()) {
                supplierObservableList.add(new Supplier(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return supplierObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
