package main.models.dao;

import main.exceptions.UserException;
import main.models.connection.DBConnection;
import main.models.entity.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User u) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(u);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean userExist(String mail) {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("mail", mail)).uniqueResult();
        session.close();
        if (user == null) {
            return false;
        }
        return true;
    }
}
