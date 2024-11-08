package service;

import service.custom.impl.CartItemServiceImpl;
import service.custom.impl.ProductServiceImpl;
import service.custom.impl.SupplierServiceImpl;
import util.ServiceType;

public class ServiceFactory {

    private static ServiceFactory factory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){return factory!=null?factory:(factory=new ServiceFactory());}

    public <T extends SuperService>T getServiceType(ServiceType serviceType){
        switch (serviceType){
            case PRODUCT:return (T) new ProductServiceImpl();
            case CARDITEM:return (T) new CartItemServiceImpl();
            case SUPPLIER:return (T) new SupplierServiceImpl();


        }
        return null;

    }
}
