package repository.custom.impl;

import dto.Product;
import dto.Supplier;
import entity.CardItemEntity;
import javafx.collections.ObservableList;
import repository.custom.CartItemDao;

import java.util.List;

public class CartItemDaoImpl implements CartItemDao {
    @Override
    public boolean save(CardItemEntity entity) {
        return false;
    }

    @Override
    public boolean update(CardItemEntity entity) {
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
        return null;
    }
}
