package main.models.dao;

import main.models.entity.Plan;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.models.connection.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 19.04.2017.
 */
@Repository
public class PlanDaoImpl implements PlanDao {

    private static Logger logger = Logger.getLogger(PlanDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Plan plan = (Plan) session.get(Plan.class, id);
        session.delete(plan);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Plan> getAll(boolean joinProduct) throws SQLException {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Plan> list = session.createCriteria(Plan.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Plan get(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Plan plan = (Plan) session.get(Plan.class, id);
        transaction.commit();
        session.close();
        return plan;
    }

    @Override
    public boolean update(Plan plan) {
        return false;
    }

    @Override
    public void delete(Plan plan) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(plan);
        transaction.commit();
        session.close();
    }

    @Override
    public void insert(Plan plan) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(plan);
        transaction.commit();
        session.close();
    }

    @Override
    public void insert(Date date, Integer idProduct, Integer quantity, Integer cost) throws SQLException {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Plan plan = new Plan(date, quantity, cost);
        session.persist(plan);
        transaction.commit();
        session.close();
    }

    @Override
    public void updatePlan(Integer idPlan, Date date, Integer idProduct, Integer quantity, Integer cost) throws SQLException {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE plans SET(" +
                    " plan_data, plan_quantity, plan_cost, plan_user_id, plan_product_id)" +
                    " = (?, ?, ?, ?, ?) WHERE plan_id = ? RETURNING plan_id");
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, cost);
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, idProduct);
            preparedStatement.setInt(6, idPlan);
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.warn("SQLException in Plan.updatePlan()");
            throw e;
        }
    }

    @Override
    public void save() {

    }
}

