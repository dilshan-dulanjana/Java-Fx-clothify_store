package repository;

import repository.custom.impl.CartItemDaoImpl;
import repository.custom.impl.ProductDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;


    public <T extends SuperDao>T getDaoType(DaoType daoType){
        switch (daoType){
            case PRODUCT :return (T) new ProductDaoImpl();
            case CARDITEM: return (T) new CartItemDaoImpl();
            case SUPPLIER :return (T) new SupplierDaoImpl();
        }
        return null;
    }

    public static DaoFactory getInstance(){return instance!=null?instance:(instance=new DaoFactory());}
}
