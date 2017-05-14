package main.models.dao;

import main.controllers.listeners.NewAppStartListener;
import main.models.connection.DBConnection;
import main.models.entity.Product;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);
    private Product product;
    private SessionFactory sessionFactory;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAll() {
        Session session = this.sessionFactory.openSession();
        //List<Product> productList = session.createCriteria(Product.class).list();
        List<Product> productList = session.createQuery(" from main.models.entity.Product").list();
        session.close();
        return productList;
    }

    public void insert(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
    }

}
