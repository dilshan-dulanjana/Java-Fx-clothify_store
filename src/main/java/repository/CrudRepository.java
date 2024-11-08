package repository;

import dto.Product;
import dto.Supplier;
import javafx.collections.ObservableList;

import java.util.List;

public interface CrudRepository <T,ID> extends SuperDao{
boolean save(T entity);

boolean update(T entity);
boolean delete(ID id);

Product search(ID id);

    ObservableList<Supplier> findAll();



}
