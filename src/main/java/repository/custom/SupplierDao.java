package repository.custom;

import entity.ProductEntity;
import entity.SupplierEntity;
import repository.CrudRepository;

public interface SupplierDao extends CrudRepository<SupplierEntity,String> {}
