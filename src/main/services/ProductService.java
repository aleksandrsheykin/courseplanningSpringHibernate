package main.services;

import main.models.entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 30.04.2017.
 */
public interface ProductService {

    List<Product> getAllProducts();
    void addProduct(String name, String desc);
    void delete(Integer id);
    void edit(Integer id, String name, String desc);
}
