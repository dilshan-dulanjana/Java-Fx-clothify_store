package service.custom.impl;

import dto.Product;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierServices;
import util.DaoType;

import java.util.List;

public class SupplierServiceImpl implements SupplierServices {
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierDao supplierDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);
        SupplierEntity entity = new ModelMapper().map(supplier,SupplierEntity.class);
        return supplierDao.save(entity);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public Product searchSupplier(Supplier supplier) {
        return null;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public ObservableList<Supplier> getAllSupplier() {
        SupplierDao supplierDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);
        return supplierDao.findAll();
    }
}
