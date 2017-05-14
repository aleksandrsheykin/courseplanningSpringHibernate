package main.models.dao;

import main.models.entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface ProductDao {

    List<Product> getAll();
    void insert(Product product);
    void delete(Integer id);
    void edit(Integer id, String name, String desc);
}