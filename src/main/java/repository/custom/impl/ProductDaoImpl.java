package repository.custom.impl;

import dto.Product;
import dto.Supplier;
import entity.ProductEntity;
import javafx.collections.ObservableList;
import repository.custom.ProductDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean save(ProductEntity product) {
        System.out.println("Repository  :"+product);
        String SQL ="INSERT INTO product VALUES(?,?,?,?,?,?,?,?)";

        try {
            return CrudUtil.execute(
                    SQL,
                    product.getProductID(),
                    product.getName(),
                    product.getQty(),
                    product.getSize(),
                    product.getUnitPrice(),
                    product.getCategory(),
                    product.getEnterdate(),
                    product.getBarcode()


                    );
        } catch (SQLException e) {
            return false;
        }

    }


    @Override
    public boolean update(ProductEntity product) {
        String SQL="Update product SET name=?,qty=?,size=?,unit_price=?,category=?,date=?,barcodeID=? WHERE product_ID=? ";
        try {
            return  CrudUtil.execute(
                    SQL,
                    product.getName(),
                    product.getQty(),
                    product.getSize(),
                    product.getUnitPrice(),
                    product.getCategory(),
                    product.getEnterdate(),
                    product.getBarcode(),
                    product.getProductID()
            );
        } catch (SQLException e) {
            return false;
        }


    }

    @Override
    public boolean delete(String id) {
        String SQL ="DELETE FROM product WHERE product_ID=?";
        try {
          return   CrudUtil.execute(SQL,id);
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public Product search(String id) {
        ResultSet resultSet = null;
        try {
            resultSet = CrudUtil.execute("SELECT * FROM product WHERE product_ID=?", id);
            if (resultSet.next()) {
                String productId = resultSet.getString(1);
                String name = resultSet.getString(2);
                double qty = resultSet.getDouble(3);
                String size = resultSet.getString(4);
                double unitPrice = resultSet.getDouble(5);
                String category = resultSet.getString(6);
                LocalDate date = LocalDate.parse(resultSet.getString(7));
                String barcodeID = resultSet.getString(8);

                Product product = new Product(barcodeID, productId, name, qty, size, unitPrice, date, category);
                System.out.println(product);
                return product;
            } else {
                System.out.println("Product not found for ID: " + id);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving product: " + e.getMessage(), e);
        }


    }

    @Override
    public ObservableList<Supplier> findAll() {
        return null;
    }
}
