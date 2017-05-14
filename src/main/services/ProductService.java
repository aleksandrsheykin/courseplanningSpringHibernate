package main.services;

import main.models.entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 30.04.2017.
 */
public interface ProductService {

    List<Product> getAllProducts();
    boolean addProduct(String name, String desc);
}
