package main.services;

import main.models.dao.ProductDao;
import main.models.entity.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private ProductDao productDao;
    private Product product;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public boolean addProduct(String name, String desc) {
        product = new Product(name, desc);
        productDao.insert(product);
        return true;
    }

}
