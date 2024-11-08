package repository.custom;

import entity.CardItemEntity;
import entity.ProductEntity;
import repository.CrudRepository;

public interface CartItemDao extends CrudRepository<CardItemEntity,String> {}
