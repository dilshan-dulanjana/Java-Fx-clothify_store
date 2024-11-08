package service.custom.impl;

import dto.Customer;
import dto.Product;
import entity.ProductEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ProductDao;
import service.custom.ProductServices;
import util.DaoType;


public class ProductServiceImpl implements ProductServices {




    @Override
    public boolean addProduct(Product product) {
        System.out.println("Product :"+product);
        ProductDao productDao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        ProductEntity entity = new ModelMapper().map(product,ProductEntity.class);

        return productDao.save(entity);
    }

    @Override
    public boolean updateProduct(Product product) {

        ProductDao productDao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        ProductEntity entity = new ModelMapper().map(product,ProductEntity.class);



        return productDao.update(entity);
    }

    @Override
    public Product searchProduct(String id) {
        System.out.println(id);

        ProductDao productDao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);

        return productDao.search(id);
    }

    @Override
    public boolean deleteProduct(String id) {
        ProductDao productDao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
      return   productDao.delete(id);

    }

    @Override
    public ObservableList<Product> getAllCustomers() {
        return null;
    }
}
