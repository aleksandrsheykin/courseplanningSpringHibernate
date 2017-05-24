package main.models.dao;

import main.models.entity.Plan;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface PlanDao {
    List<Plan> getAll(boolean joinProduct) throws SQLException;
    Plan get(int id);
    boolean update(Plan plan);
    void delete(Plan plan);
    void delete(Integer id) throws SQLException;
    void insert(Plan plan);
    void insert(Date date, Integer idProduct, Integer quantity, Integer cost) throws SQLException;
    void updatePlan(Integer idPlan, Date date, Integer idProduct, Integer quantity, Integer cost) throws SQLException;
    void save();
}